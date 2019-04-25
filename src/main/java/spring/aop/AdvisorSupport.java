package spring.aop;


import org.aopalliance.intercept.MethodInterceptor;

/**
 * @Auther: cjw
 * @Date: 2019/1/3 17:48
 * @Description:
 */
public class AdvisorSupport {



    private MethodInterceptor methodInterceptor;

    //被代理的对象
    private TargetSource targetSource;

    private MethodMather methodMather;

    public MethodMather getMethodMather() {
        return methodMather;
    }

    public void setMethodMather(MethodMather methodMather) {
        this.methodMather = methodMather;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }
}
