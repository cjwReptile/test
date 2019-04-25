package design.observer;

/**
 * @Auther: cjw
 * @Date: 2019/1/3 16:14
 * @Description:
 */
public interface SubjectInterface {

    void addObserver(ObserverInterface observer);

    void remove(ObserverInterface observer);

    void notifyall();
}
