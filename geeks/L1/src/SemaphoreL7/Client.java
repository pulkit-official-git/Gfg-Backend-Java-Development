package SemaphoreL7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {

        ExecutorService ex = Executors.newCachedThreadPool();
        Store store = new Store(5);
        Semaphore prodSemaphore = new Semaphore(5);
        Semaphore consSemaphore = new Semaphore(0);
//        List<Future<?>> futures = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
//            Future<?> future=ex.submit(new Producer(store));
//            futures.add(future);
            ex.execute(new Producer(store,prodSemaphore,consSemaphore));
        }

        for (int i = 1; i <= 20; i++) {
//            Future<?> future=ex.submit(new Consumer(store));
//            System.out.println("Consumer section");
//            futures.add(future);
            ex.execute(new Consumer(store,prodSemaphore,consSemaphore));
        }
//        for (Future<?> future : futures) {
//            try {
//                System.out.println(future.get());  // Blocks and retrieves any exception thrown inside run()
//            } catch (ExecutionException e) {
//                System.err.println("Task Exception: " + e.getCause());  // Print the actual exception
//            } catch (InterruptedException e) {
//                System.err.println("Task was interrupted: " + e.getMessage());
//            }
//        }
//        ex.shutdown();

    }
}
