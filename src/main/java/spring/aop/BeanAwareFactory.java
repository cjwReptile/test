package spring.aop;

import spring.factory.BeanFactory;

/**
 * @Auther: cjw
 * @Date: 2019/1/4 17:23
 * @Description:
 */
public interface BeanAwareFactory {

    void setBeanFactory(BeanFactory factory);
}
