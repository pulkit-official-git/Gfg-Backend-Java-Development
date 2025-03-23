package CallableL5;

import Interfaces.Lis;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSort implements Callable <List<Integer>> {

    List<Integer> l;
    ExecutorService ex;

    public MergeSort(List<Integer> l,ExecutorService ex) {
        this.l = l;
        this.ex=ex;
    }

    @Override
    public List<Integer> call() throws Exception {
        if(l.size()<=1){
            return l;
        }
        int mid = l.size()/2;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for(int i=0; i<mid; i++){
            left.add(l.get(i));
        }
        for(int i=mid+1; i<l.size(); i++){
            right.add(l.get(i));
        }
        Future<List<Integer>> leftOrder=ex.submit(new MergeSort(left,ex));
        Future<List<Integer>> rightOrder=ex.submit(new MergeSort(right,ex));

        List<Integer>orderedLeft = leftOrder.get();
        List<Integer>orderedRight = rightOrder.get();

        List<Integer> result = new ArrayList<>();
        int i=0,j=0;
        while(i<orderedLeft.size() && j<orderedRight.size()){
            if(orderedLeft.get(i)<orderedRight.get(j)){
                result.add(orderedLeft.get(i));
                i++;
            }
            else{
                result.add(orderedRight.get(j));
                j++;
            }
        }
        while(i<orderedLeft.size()){
            result.add(orderedLeft.get(i));
            i++;
        }
        while(j<orderedRight.size()){
            result.add(orderedRight.get(j));
            j++;
        }
        System.out.println(result);
        return result;
    }
}
