package design.test1.simplefatory.factory;

/**
 * @Auther: cjw
 * @Date: 2019/3/19 15:49
 * @Description:
 */
public class NannyFactory extends CategoryFactory{
    @Override
    DetailService detailService() {
        return new NannyDetailService();
    }

    @Override
    IndexService indexService() {
        return null;
    }

    @Override
    ListService listService() {
        return null;
    }
}
