package MergeSort;

import Interfaces.Lis;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {

    private List<Integer> arrToSort;
    ExecutorService ex;

    public Sorter(List<Integer> arrToSort, ExecutorService ex) {
        this.arrToSort = arrToSort;
        this.ex = ex;
    }

    @Override
    public List<Integer> call() throws Exception {
        if(arrToSort.size()<=1){
            return arrToSort;
        }
        int mid = arrToSort.size()/2;

        List<Integer>left = new ArrayList<>();
        List<Integer>right = new ArrayList<>();
        for(int i=0; i<mid; i++){
            left.add(arrToSort.get(i));
        }
        for(int i=mid; i<arrToSort.size(); i++){
            right.add(arrToSort.get(i));
        }
        Sorter taks1 = new Sorter(left,ex);
        Sorter taks2 = new Sorter(right,ex);

        Future<List<Integer>> sortLeft=ex.submit(taks1);
        Future<List<Integer>> sortRight=ex.submit(taks2);

        List<Integer>leftSorted = sortLeft.get(); //wait
        List<Integer>rightSorted = sortRight.get();

        List<Integer>result=new ArrayList<>();
        int i=0,j=0;

        while(i<leftSorted.size() && j<rightSorted.size()){
            if(leftSorted.get(i)<rightSorted.get(j)){
                result.add(leftSorted.get(i));
                i++;
            }
            else {
                result.add(rightSorted.get(j));
                j++;
            }
        }
        while(i<leftSorted.size()){
            result.add(leftSorted.get(i));
            i++;
        }
        while(j<rightSorted.size()){
            result.add(rightSorted.get(j));
            j++;
        }
        return result;

    }
}
