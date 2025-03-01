package Mutex;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Adder implements Callable<Void> {
    private Count count;
//    private Lock lock;

    public Adder(Count count) {
        this.count = count;
//        this.lock = lock;
    }

    @Override
    public Void call() throws Exception {
        for(int i=1;i<=10000;i++){
//            lock.lock();
//            synchronized (count){
//                count.value+=i;
//            }
            count.incrementByX(i);
//            lock.unlock();
        }
        return null;
    }
}
