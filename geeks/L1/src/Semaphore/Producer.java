package Semaphore;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    private Shop shop;
    private Semaphore prodSemaphore;
    private Semaphore consSemaphore;
    public Producer(Shop shop,Semaphore prodSemaphore,Semaphore consSemaphore) {
        this.shop = shop;
        this.prodSemaphore = prodSemaphore;
        this.consSemaphore=consSemaphore;
    }
    @Override
    public void run() {
        while (true){
            try {
                prodSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            shop.addItem();
            consSemaphore.release();

        }
    }
}
