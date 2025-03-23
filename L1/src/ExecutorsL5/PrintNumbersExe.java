package ExecutorsL5;

public class PrintNumbersExe implements Runnable{

    int noToPrint;

    public PrintNumbersExe(int noToPrint) {
        this.noToPrint = noToPrint;
    }

    @Override
    public void run() {
        System.out.println("Thread name: " + Thread.currentThread().getName()+" Number to print: " + noToPrint);
    }
}
