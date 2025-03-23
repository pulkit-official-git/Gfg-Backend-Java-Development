package Executors;

import PrintNumbersThread.PrintNumbers;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
//        ExecutorService ex = Executors.newFixedThreadPool(20);
        ExecutorService ex = Executors.newCachedThreadPool();
        for(int i=1;i<=10000;i++){
            if(i==8000){
                System.out.println("Hey");
            }
            PrintNumbers task = new PrintNumbers(i);
            ex.submit(task);
        }
    }
}
