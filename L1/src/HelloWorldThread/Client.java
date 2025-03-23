package HelloWorldThread;

public class Client {

    static void doSomething(){
        System.out.println("Thread with do()"+ Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        System.out.println("Thread Name: " + Thread.currentThread().getName());
        doSomething();

        PrintHelloWorld printHelloWorld = new PrintHelloWorld();

        Thread t1 = new Thread(printHelloWorld);
        t1.start();


//        printHelloWorld.run();
    }
}
