package spring.factory;

/**
 * @Auther: cjw
 * @Date: 2019/1/2 16:18
 * @Description:
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;
}
