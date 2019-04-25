package spring.factory;

import org.apache.commons.collections.CollectionUtils;
import spring.aop.BeanPostProcess;
import spring.ioc.bean.BeanDefinition;
import spring.ioc.xml.XmlReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: cjw
 * @Date: 2019/1/2 16:16
 * @Description:
 */
public abstract class AbstractBeanFactory implements BeanFactory{

    private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    public AbstractBeanFactory() {

    }

    @Override
    public Object getBean(String name) throws Exception {

        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if(beanDefinition == null){
            return null;
        }
        Object bean = beanDefinition.getBean();
        if(bean == null){
            bean = doCreateBean(beanDefinition);
            bean = initialbean(bean);
            beanDefinition.setBean(bean);
        }
        return bean;
    }

    public Object createBean(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    public Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object beanInstanse = createBean(beanDefinition);
        beanDefinition.setBean(beanInstanse);
        applyProperties(beanInstanse,beanDefinition);
        return beanInstanse;
    }

    public Map<String, BeanDefinition> getBeanDefinitionMap() {
        return beanDefinitionMap;
    }

    public void setBeanDefinitionMap(Map<String, BeanDefinition> beanDefinitionMap) {
        this.beanDefinitionMap = beanDefinitionMap;
    }

    public List getBeansByType(Class clazz) throws Exception {
        List beans = new ArrayList<Object>();
        for(Map.Entry<String,BeanDefinition> entry : beanDefinitionMap.entrySet()){
            if(clazz.isAssignableFrom(entry.getValue().getBeanClass())){
                beans.add(getBean(entry.getKey()));
            }
        }
        return beans;
    }

    public Object initialbean(Object bean) throws Exception {

        List<BeanPostProcess> aopBeans = getBeansByType(BeanPostProcess.class);

        for(BeanPostProcess postProcess : aopBeans){
            bean = postProcess.processBeforInit(bean);
        }
        for(BeanPostProcess postProcess : aopBeans){
            bean = postProcess.processAfterInit(bean);
        }
        return bean;

    }

    public abstract void applyProperties(Object bean,BeanDefinition beanDefinition) throws Exception;
}
