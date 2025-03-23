package DeepCopy;

public class Client {
    public static void main(String[] args) {
        Student s1 = new Student("Pulkit",27,12345);
        Student s2 = new Student(s1);
        Student s3 = new Student(s1);
        Student s4 = s1;
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s4);


    }
}
