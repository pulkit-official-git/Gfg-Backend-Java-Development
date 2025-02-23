package LamdaL4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

public class Client {

//    Comparable
//    Comparator
//    Runnable
//Callable
    public static void main(String[] args) {
        List<Student> lt = new ArrayList<Student>();
        lt.add(new Student(1,80,25,"harsh"));
        lt.add(new Student(2,70,25,"xy"));
        lt.add(new Student(3,90,25,"yz"));
        lt.add(new Student(4,50,25,"ln"));


//        Method1
        Collections.sort(lt,new ScoreComparator());
        for(Student s : lt){
            System.out.println(s.id+" "+s.score+" "+s.name);
        }

//        Method2
        Collections.sort(lt, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.score-o2.score;
            }
        });
        for(Student s : lt){
            System.out.println(s.id+" "+s.score+" "+s.name);
        }

//        Method 3

        Collections.sort(lt,( a, b)->{
            if(a.score<b.score){
                return 1;
            }
            else {
                return -1;
            }
        });


//        Method 4
        Collections.sort(lt,(a,b)-> a.score - b.score);


        MathematicalOperations m = new Addition();
        m.calculate(10,6);

        MathematicalOperations m2 = (a,b)->a+b;
        System.out.println(m2.calculate(10,9));
    }
}
//Lambda syntax
//()->{}
//datatypes -> method