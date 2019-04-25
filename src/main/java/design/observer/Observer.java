package design.observer;

/**
 * @Auther: cjw
 * @Date: 2019/1/3 16:13
 * @Description:
 */
public class Observer implements ObserverInterface{
    @Override
    public void update(String message) {
        System.out.println(message);
    }
}
