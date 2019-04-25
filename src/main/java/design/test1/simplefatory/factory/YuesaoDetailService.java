package design.test1.simplefatory.factory;

/**
 * @Auther: cjw
 * @Date: 2019/3/19 15:53
 * @Description:
 */
public class YuesaoDetailService implements DetailService{


    @Override
    public void detail() {
       SingleTon.Connect.getFactory();
    }
}
