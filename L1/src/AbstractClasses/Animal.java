package AbstractClasses;

public abstract class Animal {
    String name;
    int age;
    abstract void eat();
    abstract void sound();
    void walk() {
        System.out.println("I'm walking");
    }
}
