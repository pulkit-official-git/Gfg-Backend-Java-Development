package Collections;

import Abstraction.Array;

import java.util.Arrays;
import java.util.Comparator;

public class SampleCollection {

    public static void main(String[] args) {
        Integer [] arr = {1,2,9,5,6,4,7,8,9};
//
        Arrays.sort(arr,new Comparator<Integer>() {

            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
//
//        for(int i=0; i<arr.length; i++){
//            System.out.println(arr[i]);
//        }
//
        Person[] people = {
                new Person("John", 19),
                new Person("Doe", 20),
                new Person("fog", 21),
                new Person("grace", 21),
                new Person("kayle", 20),
        };

        sort(people);
        print(people);

    }
    public static void print(Person[] people){
        for(Person p: people){
            System.out.println(p.getName());
        }
    }
    public static void sort(Person[] people){
        Arrays.sort(people,new Person());
    }
}
