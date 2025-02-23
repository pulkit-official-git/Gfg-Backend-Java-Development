package Generics;

//public class Pair<GFG,Geeks> {
//    GFG first;
//    Geeks second;
//}
public class Pair<A,B> {
    A first;
    B second;

    public void doSomething(B b){
        System.out.println(b);
    }

    public static <A> void staticDoSomething(A a){
        System.out.println(a);
    }

    public <Z> void doingSomething(Z z){
        System.out.println("doing something");
    }

    void setFirst(A a) {
        this.first = a;
    }

    B getSecond(){
        return this.second;
    }
}
