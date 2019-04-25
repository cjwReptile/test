package spring.aop;

/**
 * @Auther: cjw
 * @Date: 2019/1/4 15:30
 * @Description: 拦截类接口
 */
public interface BeanPostProcess {

    Object processBeforInit(Object bean);

    Object processAfterInit(Object bean) throws Exception;

}
