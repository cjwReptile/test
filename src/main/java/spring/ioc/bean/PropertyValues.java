package spring.ioc.bean;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: cjw
 * @Date: 2019/1/2 11:13
 * @Description:
 */
public class PropertyValues {

    private List<PropertyValue> propertyValues = new ArrayList<PropertyValue>();

    private Map<String,String> hasAddMap = new HashMap<String, String>();


    public void addProperty(PropertyValue value){
        if(hasAddMap.get(value.getName()) != null){
            return;
        }
        propertyValues.add(value);
        hasAddMap.put(value.getName(),value.getName());
    }

    public List<PropertyValue> getPropertyValues(){
        return this.propertyValues;
    }
}
