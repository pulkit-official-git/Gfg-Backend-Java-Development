package LockAdderSubtractorL6;

public class Count {
    public int value=0;

    public synchronized void addNumber(int n){
        value+=n;
    }

    public synchronized void subtractNumber(int n){
        value-=n;
    }
}
