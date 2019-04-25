package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Auther: cjw
 * @Date: 2019/3/29 17:26
 * @Description:
 */
public class ReptileFuture implements Future {

    Sync sync;

    private List<AsyncCallback> pendingCallbacks = new ArrayList<AsyncCallback>();

    ReptileFuture(){
        sync = new Sync();
    }


    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return sync.release(-1);
    }

    @Override
    public Object get() throws InterruptedException, ExecutionException {
        sync.acquire(-1);
        System.out.println("ssssssssssss");
        return null;
    }

    @Override
    public Object get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        sync.acquire(-1);

        return null;
    }

    class Sync extends AbstractQueuedSynchronizer{

        private  int done = 1;

        private final int pending = 0;

        @Override
        protected boolean tryAcquire(int arg) {
            return getState() == done;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if(getState() == pending){
                if(compareAndSetState(pending,done)){
                    return true;
                }else {
                    return false;
                }
            }else {
                return true;
            }
        }
    }


}
