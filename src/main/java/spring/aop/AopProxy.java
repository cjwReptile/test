package spring.aop;

/**
 * @Auther: cjw
 * @Date: 2019/1/4 14:57
 * @Description: 获取被代理之后的代理对象
 */
public interface AopProxy {

    Object getProxy();
}
