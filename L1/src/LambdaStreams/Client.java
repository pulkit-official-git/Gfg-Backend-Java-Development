package LambdaStreams;



import java.util.*;
import java.util.concurrent.Callable;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Client {

//    Runnable
//    Comparator
//    Comparable
//    Callable
    public static void main(String[] args) {
        List<Student> lt = new ArrayList<>();
        lt.add(new Student(1,80,25,"harsh"));
        lt.add(new Student(2,70,25,"xy"));
        lt.add(new Student(3,90,25,"yz"));
        lt.add(new Student(4,50,25,"ln"));

//        Method 1
//        Collections.sort(lt,new ScoreComparator());
//        for (Student s : lt) {
//            System.out.println(s.id+" "+s.score+" "+s.name);
//        }


//        Method 2
//        Collections.sort(lt, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o2.id-o1.id;
//            }
//        });
//        for (Student s : lt) {
//            System.out.println(s.id+" "+s.score+" "+s.name);
//        }

//Method 3
//        Collections.sort(lt, (Student s1,Student s2)->{
//            if(s1.score<s2.score){
//                return 1;
//            }
//            else {
//                return -1;
//            }
//        });

//        Method 4
        Collections.sort(lt, (Student s1,Student s2)-> s2.score.compareTo(s1.score));
        for (Student s : lt) {
            System.out.println(s.id+" "+s.score+" "+s.name);
        }


//        MathematicalOperation m = new Addition();
//        m.calculate(10,20);
        MathematicalOperation m = (a,b)-> a+b;
        System.out.println(m.calculate(10,20));



        List<Integer> sl = List.of(1,4,7,4,6,8,9);
        Stream<Integer>st1 = sl.stream();
        Stream<Integer>st2 = sl.stream();
        System.out.println(st1);
//        System.out.println(st1.limit(10));
        System.out.println(st1.limit(7).count());
//        System.out.println(st2.limit(1).count());
        System.out.println(sl);

        st2.limit(5).forEach((ele)-> {
            System.out.println(ele);
        });

//        List<Integer> evenList= sl.
//                stream().
//                filter((ele)->ele%2==0)
//                .collect(Collectors.toList());
//        System.out.println(evenList);

//        List<Integer> evenList= sl.
//                stream().
//                filter((ele)->ele%2==0).
//                map((elem)->elem*elem)
//                .collect(Collectors.toList());
//        System.out.println(evenList);

        List<Integer> evenList= sl.
                stream().
                filter((ele)->ele%2==0).
                map((elem)->elem*elem).
                sorted((e,f)->f-e).
                collect(Collectors.toList());
        System.out.println(evenList);

        Optional<Integer> x= sl.
                stream().
                filter((ele)->ele%2==0).
                map((elem)->elem*elem).
                sorted((e,f)->f-e).
                findFirst();
        System.out.println(x.get());

        int sum=0;
        for( Integer t : sl){
            sum+=t;
        }
        System.out.println(sum);

        Integer reducedSum= sl.
                stream().
                filter((ele)->ele%2==0).
                map((elem)->elem*elem).
                sorted((e,f)->f-e).
                reduce(0,(prev,curr)->prev+curr);
        System.out.println(reducedSum);


        Integer minValue= sl.
                stream().
                filter((ele)->ele%2==0).
                map((elem)->elem*elem).
                sorted((e,f)->f-e).
                reduce(Integer.MAX_VALUE,(prev,curr)->Math.min(prev,curr));
        System.out.println(minValue);


    }
}
