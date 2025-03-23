package ProducerConsumer;

public class Producer implements Runnable {
    private Shop shop;
    public Producer(Shop shop) {
        this.shop = shop;
    }
    @Override
    public void run() {
        while (true){
//            synchronized (shop){
                if(shop.getItems().size()<shop.getMaxSize()){
                    shop.addItem();
//                }
            }

        }
    }
}
