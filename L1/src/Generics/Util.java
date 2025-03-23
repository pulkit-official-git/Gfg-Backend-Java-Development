package Generics;

import java.util.List;

public class Util {

    public static void printName(List<? extends Animal> animals) {
        for(Animal animal : animals) {
            System.out.println(animal.name);
        }

//        animals.add(new Cat());
//        animals.add(new Dog());
    }
    public static <T extends Animal>void doSomething(List<T> animals) {
        for(Animal animal : animals) {
            System.out.println(animal.name);
        }

//        animals.add(new Cat());
//        animals.add(new Dog());
    }
}
