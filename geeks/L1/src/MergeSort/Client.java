package MergeSort;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws Exception {
        ExecutorService ex = Executors.newCachedThreadPool();
//        ExecutorService ex = Executors.newFixedThreadPool(5);
        List<Integer> arrToSort = List.of(8,1,2,3,5,7,3,4);
        Sorter task = new Sorter(arrToSort,ex);
        Future<List<Integer>> ans=ex.submit(task);
        List<Integer> finalSorted=ans.get();
        System.out.println(finalSorted);
    }
}
