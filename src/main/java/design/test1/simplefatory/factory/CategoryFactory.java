package design.test1.simplefatory.factory;

/**
 * @Auther: cjw
 * @Date: 2019/3/19 15:44
 * @Description:
 */
public abstract class CategoryFactory {

    abstract DetailService detailService();

    abstract IndexService indexService();

    abstract ListService listService();
}
