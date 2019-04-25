package spring.ioc.xml;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import spring.io.ResourceLoader;
import spring.ioc.bean.BeanDefinition;
import spring.ioc.bean.BeanReference;
import spring.ioc.bean.PropertyValue;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: cjw
 * @Date: 2018/12/11 17:00
 * @Description:
 */
public class XmlReader extends AbstractXmlReader{

    private ResourceLoader resourceLoader;

    public XmlReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBean(String location) throws Exception {
        InputStream inputStream =getResourceLoader().getUrlResource(location).getResource();
        loadBeanDefinations(inputStream);
    }

    /**
     *
     * 功能描述:格式流文件
     * @param:
     * @return:
     * @auther: cjw
     * @date: 2019/1/2 10:46
     */
    private void loadBeanDefinations(InputStream inputStream) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        Document doc = docBuilder.parse(inputStream);
        registryBeanDefination(doc);
    }

    private void registryBeanDefination(Document document){
        Element element = document.getDocumentElement();
        NodeList nodes = element.getChildNodes();
        for(int i=0; i<nodes.getLength();i++){
            Node node = nodes.item(i);
            if(node instanceof Element){
                Element element1 = (Element)node;
                parseBeanDefinnation(element1);
            }
        }
    }

    private void parseBeanDefinnation(Element element){
        String id = element.getAttribute("id");
        String name = element.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setClassName(name);
        loadProperties(element,beanDefinition);
        getRegistry().put(id,beanDefinition);
    }

    private void loadProperties(Element element,BeanDefinition beanDefinition){

        NodeList nodeList = element.getElementsByTagName("property");
        for(int i = 0; i < nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            if(node instanceof Element){
                Element ele = (Element)node;
                String name = ele.getAttribute("name");
                String value = ele.getAttribute("value");
                if(value != null && value.length() > 0){
                    PropertyValue propertyValue = new PropertyValue(name,value);
                    beanDefinition.getPropertyValues().addProperty(propertyValue);
                }else {
                    String ref = ele.getAttribute("ref");
                    BeanReference reference = new BeanReference(ref);
                    beanDefinition.getPropertyValues().addProperty(new PropertyValue(name,reference));
                }
            }
        }

    }


}
