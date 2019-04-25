package spring.aop;

/**
 * @Auther: cjw
 * @Date: 2019/1/3 17:48
 * @Description: 切点，定义需要拦截的点，所以拥有类匹配方法  和 拦截方法的接口方法
 */
public interface Pointcut{

    ClassMather getClassMather();

    MethodMather getMethodMather();
}
