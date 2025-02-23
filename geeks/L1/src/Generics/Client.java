package Generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Pair pair = new Pair();
        pair.first="ABC";
        pair.second="DEF";
        pair.first=1223334;
        pair.second= List.of(3,4,5);


//        CountryName and Population

        Pair<String,Integer> p2 = new Pair<String,Integer>();
//        p2.first=1234;
        p2.first="khan";
        p2.second=13;
//        String x = p2.getSecond();
        Integer x = p2.getSecond();

        Pair<String,Integer>p3 = new Pair</*Optional*/>();

        HashMap hm = new HashMap();
        hm.put("khan",1);
        hm.put(123,290);
        hm.put("list",89.8);

        //     if this is not good practice y is this even allowed these days?

        Pair<String,Integer>p5 = new Pair<>();
        p5.doSomething(100);
        p5.<String>doingSomething("abc");
        p5.doingSomething("abc");
        p5.doingSomething(123);

        System.out.println(p2.getClass().getName());

        Pair.staticDoSomething(10);

        List<Dog>d = new ArrayList<Dog>();
        Dog temp = new Dog();
        temp.name="dpg1";
        d.add(new Dog());
        d.add(temp);

        Util.printName(d);

        List<Cat> ct = new ArrayList<>();
        ct.add(new Cat());
        Util.doSomething(ct);



    }
}
