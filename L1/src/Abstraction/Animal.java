package Abstraction;

public abstract class Animal {
    protected String name;
    protected int age;
    abstract void eat();
    abstract void sound();
    void printName(){
        System.out.println("name");
    }
}
