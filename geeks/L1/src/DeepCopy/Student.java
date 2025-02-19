package DeepCopy;

public class Student {
    String name;
    int age;
    int rollNo;

    Student(){

    }
     Student(String name, int age, int rollNo) {
         this.name = name;
         this.age = age;
         this.rollNo = rollNo;
     }

     Student (Student student){
        this.name = student.name;
        this.age = student.age;
        this.rollNo = student.rollNo;
     }
}
