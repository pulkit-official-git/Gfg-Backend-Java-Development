package PrintNumbersL5;

public class PrintNumberUsingThread implements Runnable{

    int printNumber;

    public PrintNumberUsingThread(int printNumber) {
        this.printNumber = printNumber;
    }

    @Override
    public void run() {
        System.out.println("Printing number: " + printNumber+" with Thread"+Thread.currentThread().getName());

    }
}
