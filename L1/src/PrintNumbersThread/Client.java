package PrintNumbersThread;

public class Client {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            PrintNumbers task = new PrintNumbers(i);
            if(i==80){
                int x=i;
            }
//            tank.run();
            Thread t = new Thread(task);
            t.start();

        }
    }
}
