package Polymorphism;

public class Client {
    public static void main(String[] args) {
        A obj = new A();
        obj.doSomething(6);
        A obj2 = new B();
        obj2.doSomething(10);
//        obj.doSomething("name");

    }
}
