package Singleton;

public class Client {
    public static void main(String[] args) {
        RedisConfig rc = RedisConfig.getInstance();
        System.out.println(rc.getUrl());
        Client2 c = new Client2();
        c.main();

    }
}
