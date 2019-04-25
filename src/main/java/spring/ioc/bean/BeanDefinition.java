package spring.ioc.bean;

import java.util.List;
import java.util.Map;

/**
 * @Auther: cjw
 * @Date: 2018/12/11 16:56
 * @Description: java bean容器
 */
public class BeanDefinition {


    private String className;

    private Class beanClass;

    private Object bean;

    private PropertyValues propertyValues = new PropertyValues();


    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
        try {
            this.beanClass = Class.forName(this.className);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
