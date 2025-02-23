package Collections;

import java.util.Comparator;

public class Person implements Comparator<Person> {

    private String name;
    private int attendance;

    public Person(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
    }
    public Person(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    @Override
    public int compare(Person p1, Person p2) {
        if(p1.attendance==p2.attendance){
            return p1.name.compareTo(p2.name);
        }
        return p2.attendance-p1.attendance;
    }
}
