package ProducerConsumerL6;

public class Consumer implements Runnable {

    Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while(true){
//            synchronized (store){
                if(store.getX().size()>0){
                    store.removeItem();
                }
//            }

        }

    }
}
