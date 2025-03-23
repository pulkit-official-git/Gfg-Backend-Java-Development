package LockAdderSubtractorL6;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Subtractor implements Callable<Void> {

    public Subtractor(Count count,Lock lock) {
        this.count = count;
        this.lock = lock;
    }

    public Count count;
    public Lock lock;
    @Override
    public Void call() throws Exception {
        for(int i=1;i<=100;i++){
//            lock.lock();
//            synchronized (count){
//                count.value-=i;
//            }
//            count.value-=i;
//            lock.unlock();
            count.subtractNumber(i);
        }
        return null;
    }
}
