package LockAdderSubtractorL6;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Adder implements Callable<Void> {

    public Adder(Count count, Lock lock) {
        this.count = count;
        this.lock = lock;
    }

    public Count count;
    public Lock lock;
    @Override
    public Void call() throws Exception {
        for (int i = 1; i <= 100; i++) {
//            lock.lock();
//            synchronized (count){
//                count.value+=i;
//            }
//            count.value+=i;
//            lock.unlock();
            count.addNumber(i);
        }
        return null;
    }
}
