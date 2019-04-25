package design.test1.simplefatory.factory;

/**
 * @Auther: cjw
 * @Date: 2019/3/19 15:53
 * @Description:
 */
public class YuesaoFactory extends CategoryFactory{
    @Override
    DetailService detailService() {
        return new YuesaoDetailService();
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
