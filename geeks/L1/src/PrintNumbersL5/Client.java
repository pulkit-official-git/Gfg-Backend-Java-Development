package PrintNumbersL5;

public class Client {
    public static void main(String[] args) {
        for(int i = 1; i <= 100; i++){

            if(i==80){
                System.out.println(i);
            }
            PrintNumberUsingThread task = new PrintNumberUsingThread(i);
            Thread thread = new Thread(task);
            thread.start();
        }
    }
}
