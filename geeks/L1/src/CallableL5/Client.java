package CallableL5;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

    public static void main(String[] args) throws Exception {
        ExecutorService ex = Executors.newCachedThreadPool();
        List<Integer> list = List.of(3,2,4,1,7,4,6,7);
        MergeSort mergeSort = new MergeSort(list,ex);
        Future<List<Integer>> listFuture=ex.submit(mergeSort);
        List<Integer>ans = listFuture.get();
        System.out.println(ans);


    }
}
