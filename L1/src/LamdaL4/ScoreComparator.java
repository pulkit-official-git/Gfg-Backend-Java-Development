package LamdaL4;

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

    }
}
