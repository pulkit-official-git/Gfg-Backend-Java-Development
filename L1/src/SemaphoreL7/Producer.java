package SemaphoreL7;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    Store store;
    private Semaphore prodSemaphore;
    private Semaphore consSemaphore;

    public Producer(Store store,Semaphore prodSemaphore,Semaphore consSemaphore) {
        this.store = store;
        this.prodSemaphore = prodSemaphore;
        this.consSemaphore = consSemaphore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                prodSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            store.addItem(new Items());
            consSemaphore.release();
        }
    }
}
