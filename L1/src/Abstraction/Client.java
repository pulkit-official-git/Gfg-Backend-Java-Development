package Abstraction;

public class Client extends Array{
    public static void main(String[] args) {
//        Array arr = new Array();
//        arr.random();
        Husky hus = new Husky();
        hus.sound();
        hus.printName();
        hus.skin();
    }
}
