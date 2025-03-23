package Singleton;

public class Client2 {
    public  void main() {
        RedisConfig rc = RedisConfig.getInstance();
        System.out.println(rc);
    }
}
