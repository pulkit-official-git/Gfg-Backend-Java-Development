package LockAdderSubtractorL6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {

    public static void main(String[] args) throws Exception {

        Lock lock = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Count count = new Count();
        Adder adder = new Adder(count,lock);
        Subtractor subtractor = new Subtractor(count,lock);
        ExecutorService ex = Executors.newCachedThreadPool();
        Future<Void>a= ex.submit(adder);
        Future<Void>s=ex.submit(subtractor);
        a.get();
        s.get();

        System.out.println(count.value);
        ex.shutdown();

    }
}
