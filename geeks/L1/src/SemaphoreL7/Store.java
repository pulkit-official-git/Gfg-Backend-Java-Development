package SemaphoreL7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Store {
    private int maxSize;
//    private List<Items>x;
    private ConcurrentLinkedDeque<Items>x;
    public Store(int maxSize) {
        this.maxSize = maxSize;
        x = new ConcurrentLinkedDeque<>();
    }

    public int getMaxSize() {
        return maxSize;
    }

    public ConcurrentLinkedDeque<Items> getX() {
        return x;
    }

    public void addItem(Items item) {
        x.add(item);
        System.out.println("Producer is producing : Size of " + x.size() + " items");
    }

    public void removeItem() {
        x.remove();
        System.out.println("Consumer is consuming : Size of " + x.size() + " items");
    }


}
