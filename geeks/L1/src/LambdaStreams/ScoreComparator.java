package LambdaStreams;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.score<o2.score){
            return 1;
        }
        else {
            return -1;
        }
//        return o2.score.compareTo(o1.score);

    }
}
