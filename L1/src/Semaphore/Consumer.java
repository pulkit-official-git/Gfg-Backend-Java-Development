package Semaphore;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {

    private Shop shop;
    private Semaphore prodSemaphore;
    private Semaphore consSemaphore;
    public Consumer(Shop shop,Semaphore prodSemaphore,Semaphore consSemaphore) {
        this.shop = shop;
        this.prodSemaphore=prodSemaphore;
        this.consSemaphore=consSemaphore;
    }
    @Override
    public void run() {
        while (true) {
            try {
                consSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            shop.removeItem();
            prodSemaphore.release();

        }

    }
}
