package thread;

/**
 * @Auther: cjw
 * @Date: 2019/3/29 17:25
 * @Description: 异步回调接口
 */
public interface AsyncCallback {

    void success();

    void fail();
}
