package Mutex;

public class Count {

    public int value=0;

    public synchronized void incrementByX(int x){
        value+=x;
    }

    public synchronized void decrementByX(int x){
        value-=x;
    }
}
