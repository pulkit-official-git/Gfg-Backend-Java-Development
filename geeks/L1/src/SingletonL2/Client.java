package SingletonL2;

public class Client {

    public static void main(String[] args) {
        RedisConfig rsc = RedisConfig.getInstance();
        rsc.printName();
    }
}
