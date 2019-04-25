package spring.Context;

import spring.factory.AbstractBeanFactory;
import spring.factory.BeanFactory;
import spring.ioc.bean.BeanDefinition;

import java.util.Map;

/**
 * @Auther: cjw
 * @Date: 2019/1/2 17:06
 * @Description:
 */
public abstract class AbstractApplicationContext implements ApplicationContext{

    public BeanFactory beanFactory;

    public AbstractApplicationContext(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public AbstractApplicationContext() {
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public abstract void loadBeanDefination(AbstractBeanFactory beanFactory) throws Exception;
}
