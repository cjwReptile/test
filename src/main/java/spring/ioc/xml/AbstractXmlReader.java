package spring.ioc.xml;

import spring.io.ResourceLoader;
import spring.ioc.bean.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: cjw
 * @Date: 2018/12/11 17:26
 * @Description:
 */
public abstract class AbstractXmlReader implements XmlReaderInterfaces{



    //获取资源加载器
    private ResourceLoader resourceLoader;

    //累加载map
    private Map<String,BeanDefinition> registry;

    public AbstractXmlReader(ResourceLoader resourceLoader) {
        registry = new HashMap<String, BeanDefinition>();
        this.resourceLoader = resourceLoader;
    }

    public AbstractXmlReader() {
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    private void setRegistry(Map<String, BeanDefinition> registry) {
        this.registry = registry;
    }
}
