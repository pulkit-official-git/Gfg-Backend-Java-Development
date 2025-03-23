package HelloWorldThread;

public class PrintHelloWorld implements Runnable{
    @Override
    public void run() {
        System.out.println("user thread:"+Thread.currentThread().getName());
    }
}
