package GenericsL4;

import java.util.List;

public class Util {

    public static void printNames(List<? extends Animal> animalList) {
        for (Animal animal : animalList) {
            System.out.println(animal);
        }
//        animalList.add(new Dog());
//        animalList.add(new Cat());
//        animalList.add(new Animal());
    }

    public static<T extends Animal> void printNamesMethod2(List<T> animalList) {
        for (Animal animal : animalList) {
            System.out.println(animal);
        }
//        animalList.add(new Dog());
//        animalList.add(new Cat());
//        animalList.add(new Animal());
    }
}
