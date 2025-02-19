package SingletonL2;

public class RedisConfig {
    String url;
    String username;
    String password;
    int port;

    private static RedisConfig INSTANCE=null;
    private RedisConfig(String url, String username, String password, int port) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.port = port;
    }

    public static RedisConfig getInstance() {
        if (INSTANCE == null) {
                synchronized (RedisConfig.class){
                    if (INSTANCE == null) {
                    INSTANCE = new RedisConfig("redis://localhost:6379", "root", "root", 6379);
                }

        }
    }

//            INSTANCE = new RedisConfig("redis://localhost:6379", "root", "root", 6379);
//        }
        return INSTANCE;
    }

    public void printName(){
        System.out.println("url:"+url);
    }
}
