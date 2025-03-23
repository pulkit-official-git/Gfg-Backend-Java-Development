package GenericsL4;

import java.util.HashMap;

public class Pair <S,V> {
    S x;
    V y;
    public void setX(S s){
        this.x = s;
    }
    public void getY(){
        System.out.println("Value: "+this.y);
    }

//    public void doSomething(V v){
//        System.out.println(v);
//    }
    public <V> void doSomething(V v){
        System.out.println(v);
    }

    public static <V> void staticDoSomething(V v){
        System.out.println("staticDoSomething"+v);
    }

    public <T> T doingSomething(T t){
//        System.out.println(t);
        return t;
    }
}
