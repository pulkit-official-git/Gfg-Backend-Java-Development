package Inheritance;

public class Instructor extends User{
    void schedule(){
        System.out.println("Instructor Schedule");
    }


    public static void main(String[] args) {
        Instructor i = new Instructor();
        i.printName();

    }




}
