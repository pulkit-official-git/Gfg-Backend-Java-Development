package ProducerConsumer;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private int maxSize;
    List<Items> items;

    public Shop(int maxSize) {
        this.items = new ArrayList<>();
        this.maxSize = maxSize;
    }


    public int getMaxSize() {
        return maxSize;
    }

    public List<Items> getItems() {
        return items;
    }

    public void addItem(){
        System.out.println("Producer producing item, curr size= "+this.items.size());
        this.items.add(new Items());
    }

    public void removeItem(){
        System.out.println("Consumer consuming item, curr size= "+this.items.size());
        this.items.remove(this.items.size()-1);
    }
}
