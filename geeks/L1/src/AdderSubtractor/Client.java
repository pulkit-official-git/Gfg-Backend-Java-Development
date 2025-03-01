package AdderSubtractor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws Exception {
        Count count = new Count();
        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);

        ExecutorService ex = Executors.newCachedThreadPool();
        Future<Void> a =ex.submit(adder);
        Future<Void> s =ex.submit(subtractor);
        a.get();
        s.get();

        System.out.println(count.value);
    }
}
