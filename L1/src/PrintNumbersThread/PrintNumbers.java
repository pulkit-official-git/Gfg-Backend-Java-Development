package PrintNumbersThread;

public class PrintNumbers implements Runnable{

    int noToPrint;

    public PrintNumbers(int noToPrint) {
        this.noToPrint = noToPrint;
    }

    @Override
    public void run() {
        System.out.println("Printing "+noToPrint+" using Thread "+Thread.currentThread().getName());
    }
}
