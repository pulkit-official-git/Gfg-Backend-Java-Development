package HashMapL7;

import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        HashMap <String, Integer> map = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();

        map.put("shivendra",7583);
        map.put("cherish",94754);

        System.out.println(map);
        System.out.println(map.get("shivendra"));
        map.put("pulkit",95769);
        System.out.println(map);
        for(String key : map.keySet()){
            System.out.println(map.get(key));
        }

    }


}
