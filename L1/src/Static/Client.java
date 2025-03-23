package Static;

public class Client {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
//        s1.org="x";
        s1.sendHi();
        System.out.println(Student.org);

    }
}
