package PrintHelloThreadL5;

public class PrintHello implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread Name: " + Thread.currentThread().getName());
    }
}
