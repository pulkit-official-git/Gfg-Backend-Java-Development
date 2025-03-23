package Executors;

public class PrintNumbers implements Runnable{

    int x;

    public PrintNumbers(int x) {
        this.x = x;
    }

    @Override
    public void run() {
        System.out.println("Printing numbers:"+x+"in thread"+Thread.currentThread().getName());
    }
}
