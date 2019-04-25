package design.observer;

/**
 * @Auther: cjw
 * @Date: 2019/1/3 16:20
 * @Description:
 */
public class Observer2 implements ObserverInterface{
    @Override
    public void update(String message) {
        System.out.println(message+"asdasdasda");
    }
}
