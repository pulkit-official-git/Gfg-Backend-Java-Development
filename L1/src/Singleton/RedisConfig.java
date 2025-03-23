package Singleton;

public class RedisConfig {

    private String url;
    private String password;
    private int port;
    private String user;

    private static RedisConfig instance;

    private RedisConfig(String url, String password, int port, String user) {
        this.url = url;
        this.password = password;
        this.port = port;
        this.user = user;
    }

    synchronized public static RedisConfig getInstance() {
        if (instance == null) {
            synchronized (RedisConfig.class){
                if (instance == null) {
                    instance = new RedisConfig("localhost", "strong", 3360, "root");
                }
            }
        }
        return instance;
    }

    public String getUrl() {
        return url;
    }
}
