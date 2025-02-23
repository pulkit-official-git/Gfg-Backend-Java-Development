package GenericsL4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        Pair<String,Integer> p = new Pair();
        p.x="abc";
        p.y= 7589;
        p.getY();
        p.<String>doSomething("Khan");
        p.doSomething("Khan");
        System.out.println(p.doingSomething(List.of(1,2,3,4)));
        System.out.println(Pair.class.getName());

        HashMap h = new HashMap();
        h.put(12,"dfdf");
        h.put("shfbh",9.2);

        Pair.staticDoSomething(100);

        List<Dog>dogs  = new ArrayList();
        dogs.add(new Dog());
        Dog temp = new Dog();
        temp.name="tommy";
        dogs.add(temp);

        Util.printNames(dogs);



    }
}
