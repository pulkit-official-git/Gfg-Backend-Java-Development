package PrintHelloThreadL5;



public class Client {

    static void doSomething(){
        System.out.println("Thread Do():" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println("Thread name: " + Thread.currentThread().getName());
        doSomething();

        PrintHello printHello = new PrintHello();
        Thread thread = new Thread(printHello);
        thread.start();
        printHello.run();
    }
}
