package spring.factory;

import spring.annotation.AutoWired;
import spring.aop.BeanAwareFactory;
import spring.ioc.bean.BeanDefinition;
import spring.ioc.bean.BeanReference;
import spring.ioc.bean.PropertyValue;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Auther: cjw
 * @Date: 2019/1/3 09:45
 * @Description:
 */
public class AutoApplyPropertyBeanFactory extends AbstractBeanFactory{


    @Override
    public void applyProperties(Object bean,BeanDefinition beanDefinition) throws Exception {

        if (bean instanceof BeanAwareFactory) {
            ((BeanAwareFactory) bean).setBeanFactory(this);
        }
        for(PropertyValue value : beanDefinition.getPropertyValues().getPropertyValues()){
            Object valueInstance = value.getValue();
            if(value.getValue() instanceof BeanReference){
                 valueInstance = getBean(((BeanReference) value.getValue()).getName());
            }
            try {
                String methodName = "set"+value.getName().substring(0,1).toUpperCase()+value.getName().substring(1);
                Method declareMethod = bean.getClass().getDeclaredMethod(methodName,bean.getClass());
                declareMethod.setAccessible(true);
                declareMethod.invoke(bean,valueInstance);
            }catch (NoSuchMethodException e){
                try {
                    Field field = bean.getClass().getDeclaredField(value.getName());
                    Annotation annotation = field.getAnnotation(AutoWired.class);
                    if(annotation != null){
                        if(((AutoWired) annotation).required()){
                            field.setAccessible(true);
                            field.set(bean,valueInstance);
                        }
                    }
                }catch (NoSuchFieldException e1){

                }

            }
        }
    }
}
