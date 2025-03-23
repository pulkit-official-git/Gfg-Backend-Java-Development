package ProducerConsumer;

public class Consumer implements Runnable {

    private Shop shop;
    public Consumer(Shop shop) {
        this.shop = shop;
    }
    @Override
    public void run() {
        while (true) {
//            synchronized (shop){
                if(shop.getItems().size()>0){
                    shop.removeItem();
                }
//            }

        }

    }
}
