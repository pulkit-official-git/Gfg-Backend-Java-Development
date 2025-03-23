package Semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Shop {
    private int maxSize;
//    List<Items> items;
//    Vector<Items> items;
    ConcurrentLinkedDeque<Items>items;
    public Shop(int maxSize) {
//        this.items = new ArrayList<>();
        this.maxSize = maxSize;
        items = new ConcurrentLinkedDeque<>();
    }


    public int getMaxSize() {
        return maxSize;
    }

    public ConcurrentLinkedDeque<Items> getItems() {
        return items;
    }

    public void addItem(){
        System.out.println("Producer producing item, curr size= "+this.items.size());
        this.items.offer(new Items());
    }

    public void removeItem(){
        System.out.println("Consumer consuming item, curr size= "+this.items.size());
        this.items.remove();
    }
}
