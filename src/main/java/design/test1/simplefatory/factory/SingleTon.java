package design.test1.simplefatory.factory;

/**
 * @Auther: cjw
 * @Date: 2019/3/19 16:07
 * @Description:
 */
public enum SingleTon {

    Connect;

    private NannyFactory nannyFactory;

    private SingleTon(){
        nannyFactory = new NannyFactory();
    }

    public  NannyFactory getFactory(){
        return nannyFactory;
    }
}
