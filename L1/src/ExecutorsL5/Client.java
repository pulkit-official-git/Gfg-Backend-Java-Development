package ExecutorsL5;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(10);
//        ExecutorService ex = Executors.newCachedThreadPool();
        for(int i=1;i<=1000000;i++){
            if(i==700){
                System.out.println(i);
            }
            PrintNumbersExe task = new PrintNumbersExe(i);
            ex.submit(task);
        }
    }
}
