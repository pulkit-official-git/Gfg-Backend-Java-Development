package Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newCachedThreadPool();
        Shop shop = new Shop(5);
        Semaphore prodSemaphore = new Semaphore(5);
        Semaphore consSemaphore = new Semaphore(0);

        for (int i = 1; i <= 8; i++) {
            ex.execute(new Producer(shop,prodSemaphore,consSemaphore));
        }

        for (int i = 1; i <= 20 ; i++) {
            ex.execute(new Consumer(shop,prodSemaphore,consSemaphore));
        }

    }
}
