package Mutex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) throws Exception {
        Count count = new Count();
//        Lock lock = new ReentrantLock();
        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);

        ExecutorService ex = Executors.newCachedThreadPool();
        Future<Void> a =ex.submit(adder);
        Future<Void> s =ex.submit(subtractor);
        a.get();
        s.get();

        System.out.println(count.value);
    }
}
