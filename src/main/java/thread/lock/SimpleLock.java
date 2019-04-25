package thread.lock;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Auther: cjw
 * @Date: 2019/3/30 11:09
 * @Description:
 */
public class SimpleLock  {

    //队列，此队列就是等待锁的队列
    private final AtomicReference<Node> atomicReference = new AtomicReference<Node>(new Node());

    //线程本地变量，保存当前节点
    ThreadLocal<Node> myNode;

    //线程本地变量，保存前驱节点
    ThreadLocal<Node> myPre;

    public SimpleLock(){
        myNode = new ThreadLocal<Node>(){
            @Override
            protected Node initialValue() {
                return new Node();
            }
        };
        myPre = new ThreadLocal<Node>(){
            @Override
            protected Node initialValue() {
                return null;
            }
        };
    }

    public void lock(){
        Node node = myNode.get();
        node.locked = true;
        Node pre = atomicReference.getAndSet(node);
        myPre.set(pre);
        while (pre.locked){};
    }

    public void unlock(){
        Node node = myNode.get();
        node.locked = false;
        myNode.set(myPre.get());
    }

}
