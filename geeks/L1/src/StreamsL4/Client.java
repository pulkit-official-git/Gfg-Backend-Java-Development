package StreamsL4;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Client {



    public static void main(String[] args) {
        List<Integer> l1 = List.of(4,3,5,7,2,9,8,4);
        Stream<Integer> l2 = l1.stream();
//        Stream<Integer> l3 = l1.parallelStream();
        Stream<Integer>l3 = l1.stream();
        System.out.println(l2);
//        Long x= l2.limit(10).count();
        System.out.println(l2.limit(3).count());
        System.out.println(l3.limit(4).count());
        System.out.println(l1);

        l1.stream().limit(4).forEach((ele)-> System.out.println(ele));

        List<Integer>evenList = l1.stream().
                filter((ele)->ele%2==0).
                collect(Collectors.toList());
        System.out.println(evenList);

        List<Integer>sqevenList = l1.stream().
                filter((ele)->ele%2==0).
                map((el)->el*el).
                collect(Collectors.toList());
        System.out.println(sqevenList);

        List<Integer>descsqevenList = l1.stream().
                filter((ele)->ele%2==0).
                map((el)->el*el).
                sorted((a,b)->b-a).
                collect(Collectors.toList());
        System.out.println(descsqevenList);

        Optional <Integer> maxi= l1.stream().
                filter((ele)->ele%2==0).
                map((el)->el*el).
                sorted((a,b)->b-a).
                findFirst();
        if(maxi.isPresent()){
            System.out.println(maxi.get());
        }

        Integer sum=0;
        for(int i=1;i<l1.size();i++){
            sum+=l1.get(i);
        }
        System.out.println(sum);
//        System.out.println(descsqevenList);

         Integer sumOfNumbers= l1.stream().
                filter((ele)->ele%2==0).
                map((el)->el*el).
                sorted((a,b)->b-a).
                reduce(0,(prev,curr)->prev+curr);
            System.out.println(sumOfNumbers);

        Integer mini= l1.stream().
                filter((ele)->ele%2==0).
                map((el)->el*el).
                sorted((a,b)->b-a).
                reduce(Integer.MAX_VALUE,(prev,curr)->Math.min(prev,curr));
        System.out.println(mini);


    }
}
