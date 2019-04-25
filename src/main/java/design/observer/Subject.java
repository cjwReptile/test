package design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: cjw
 * @Date: 2019/1/3 16:14
 * @Description:
 */
public class Subject implements SubjectInterface{


    private List<ObserverInterface> observerInterfaces  = new ArrayList<ObserverInterface>();

    @Override
    public void addObserver(ObserverInterface observer) {
        observerInterfaces.add(observer);
    }

    @Override
    public void remove(ObserverInterface observer) {
        observerInterfaces.remove(observer);
    }

    @Override
    public void notifyall() {
        for(ObserverInterface observer : observerInterfaces){
            observer.update("哈哈");
        }
    }
}
