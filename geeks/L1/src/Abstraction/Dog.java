package Abstraction;

public abstract class Dog extends Animal{
    @Override
    void eat() {
        System.out.println("Dog eat");
    }

    @Override
    abstract void sound();

}
