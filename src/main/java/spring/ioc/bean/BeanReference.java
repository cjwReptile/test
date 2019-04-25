package spring.ioc.bean;

/**
 * @Auther: cjw
 * @Date: 2019/1/2 15:51
 * @Description:
 */
public class BeanReference {

    private String name;

    private String bean;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBean() {
        return bean;
    }

    public void setBean(String bean) {
        this.bean = bean;
    }
}
