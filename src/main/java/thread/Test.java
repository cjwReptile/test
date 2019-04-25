package thread;

import thread.lock.SimpleLock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.LockSupport;

/**
 * @Auther: cjw
 * @Date: 2019/3/29 17:50
 * @Description:
 */
public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final ReptileFuture reptileFuture = new ReptileFuture();
        ReptileFuture reptileFuture1 = new ReptileFuture();
        final SimpleLock lock = new SimpleLock();
        lock.lock();
        for (int i = 0;i < 3;i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"开始枷锁");
                        lock.lock();
                    System.out.println(Thread.currentThread().getName()+"执行代码");
                        lock.unlock();
                }
            });
            thread.start();
        }
        System.out.println("s");
        Thread.sleep(1000);
        lock.unlock();
        System.out.println("s");
    }
}
