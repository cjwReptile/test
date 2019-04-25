package spring.aop;

/**
 * @Auther: cjw
 * @Date: 2019/1/3 17:40
 * @Description: 被代理的对象
 */
public class TargetSource {

    //被代理对象的bean实现的接口
    private Class[] targetClass;

    //被代理代理的bean
    private Object target;

    public Class[] getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class[] targetClass) {
        this.targetClass = targetClass;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
