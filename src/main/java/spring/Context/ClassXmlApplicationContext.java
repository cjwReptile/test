package spring.Context;

import spring.factory.AbstractBeanFactory;
import spring.factory.BeanFactory;
import spring.io.ResourceLoader;
import spring.ioc.bean.BeanDefinition;
import spring.ioc.xml.XmlReader;

import java.util.Map;

/**
 * @Auther: cjw
 * @Date: 2019/1/2 16:59
 * @Description:
 */
public class ClassXmlApplicationContext extends AbstractApplicationContext{

    public String location;

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }

    public ClassXmlApplicationContext(String location,AbstractBeanFactory beanFactory) throws Exception {
        super(beanFactory);
        this.location = location;
        loadBeanDefination(beanFactory);
    }

    @Override
    public void loadBeanDefination(AbstractBeanFactory beanFactory) throws Exception {
        XmlReader xmlReader = new XmlReader(new ResourceLoader());
        xmlReader.loadBean(location);
        for(Map.Entry<String,BeanDefinition> entry : xmlReader.getRegistry().entrySet()){
            beanFactory.getBeanDefinitionMap().put(entry.getKey(),entry.getValue());
        }
    }
}
