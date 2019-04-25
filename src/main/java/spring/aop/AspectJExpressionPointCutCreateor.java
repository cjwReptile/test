package spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.PointcutAdvisor;
import spring.factory.AbstractBeanFactory;
import spring.factory.BeanFactory;

import java.util.List;

/**
 * @Auther: cjw
 * @Date: 2019/1/4 17:23
 * @Description:
 */
public class AspectJExpressionPointCutCreateor implements BeanAwareFactory,BeanPostProcess{

    private AbstractBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory factory) {
        beanFactory = (AbstractBeanFactory)factory;
    }

    @Override
    public Object processBeforInit(Object bean) {
        return bean;
    }

    @Override
    public Object processAfterInit(Object bean) throws Exception {
        if(bean instanceof AspectJExpressionPointCutAdvisor){
            return bean;
        }
        if (bean instanceof MethodInterceptor) {
            return bean;
        }
        List<AspectJExpressionPointCutAdvisor> beans = beanFactory.getBeansByType(AspectJExpressionPointCutAdvisor.class);
        for(AspectJExpressionPointCutAdvisor advisor : beans){
            if(advisor.getPointcut().getClassMather().classMatch(bean.getClass())){
                TargetSource targetSource = new TargetSource();
                targetSource.setTarget(bean);
                targetSource.setTargetClass(bean.getClass().getInterfaces());
                AdvisorSupport advisorSupport = new AdvisorSupport();
                advisorSupport.setMethodMather(advisor.getPointcut().getMethodMather());
                advisorSupport.setTargetSource(targetSource);
                advisorSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
                JDKDynamicProxy jdkDynamicProxy = new JDKDynamicProxy(advisorSupport);
                return jdkDynamicProxy.getProxy();
            }
        }
        return bean;
    }
}
