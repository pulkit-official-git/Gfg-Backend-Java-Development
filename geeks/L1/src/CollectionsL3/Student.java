package CollectionsL3;

public class Student implements Comparable<Student> {
    @Override
    public int compareTo(Student o) {
        if(this.id<o.id){
            return -1;
        }else return 1;
    }

    int id;
    String name;
    int age;
    int score;

    public Student(int id, int score, int age, String name){
        this.id = id;
        this.score = score;
        this.age = age;
        this.name = name;
    }
}
