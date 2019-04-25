package spring.aop;



import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.Principal;

/**
 * @Auther: cjw
 * @Date: 2019/1/3 19:18
 * @Description:
 */
public class JDKDynamicProxy implements InvocationHandler,AopProxy {


    private AdvisorSupport advisorSupport;

    public JDKDynamicProxy(AdvisorSupport advisorSupport) {
        this.advisorSupport = advisorSupport;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MethodInterceptor methodInterceptor = advisorSupport.getMethodInterceptor();
        if(advisorSupport.getMethodMather().methodMatch(advisorSupport.getTargetSource().getTarget().getClass(),method)){
            return methodInterceptor.invoke(new ReflectMethodHandel(advisorSupport.getTargetSource().getTarget(),method,args));
        }
       return method.invoke(advisorSupport.getTargetSource().getTarget(),args);
    }

    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(getClass().getClassLoader(),advisorSupport.getTargetSource().getTargetClass(),this);
    }
}
