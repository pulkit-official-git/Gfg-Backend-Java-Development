package ProducerConsumerL6;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private int maxSize;
    private List<Items>x;
    public Store(int maxSize) {
        this.maxSize = maxSize;
        x = new ArrayList<Items>();
    }

    public int getMaxSize() {
        return maxSize;
    }

    public List<Items> getX() {
        return x;
    }

    public void addItem(Items item) {
        x.add(item);
        System.out.println("Producer is producing : Size of " + x.size() + " items");
    }

    public void removeItem() {
        x.remove(x.size()-1);
        System.out.println("Consumer is consuming : Size of " + x.size() + " items");
    }


}
