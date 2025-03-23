package LambdaStreams;

public class Student implements Comparable<Student> {
    @Override
    public int compareTo(Student o) {
        if(this.id<o.id){
            return -1;
        }else return 1;
    }

    Integer id;
    String name;
    int age;
    Integer score;

    public Student(Integer id, Integer score, int age, String name){
        this.id = id;
        this.score = score;
        this.age = age;
        this.name = name;
    }
}
