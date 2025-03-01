package AdderSubtractorL6;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void> {

    public Adder(Count count) {
        this.count = count;
    }

    public Count count;
    @Override
    public Void call() throws Exception {
        for (int i = 1; i <= 10000; i++) {
            count.value+=i;
        }
        return null;
    }
}
