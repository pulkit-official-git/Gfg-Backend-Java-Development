package CollectionsInterface;

public class Student implements Comparable<Student> {
    @Override
    public int compareTo(Student o) {
        if(this.id < o.id){
            return -1;
        }else{
            return 1;
        }
    }

    int id;
    String name;
    int age;
    int marks;

    public Student(int id, int marks, String name, int age) {
        this.id = id;
        this.marks = marks;
        this.name = name;
        this.age = age;
    }
}
