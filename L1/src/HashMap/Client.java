package HashMap;

import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("ramesh", 1);
        map.put("suresh", 2);
        System.out.println(map);
        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        for(Integer i : map.values()){
            System.out.println(i);
        }
        System.out.println(map.get("ramesh"));

        System.out.println(map.containsKey("suresh"));
        System.out.println(map.containsValue("suresh"));

        map.put("ramesh",999);
        System.out.println(map);
        map.replace("ganesh",8678);
        System.out.println(map);
        map.putIfAbsent("ganesh",999);
        System.out.println(map);
        map.putIfAbsent("ramesh",983);
        System.out.println(map);

        for(String s:map.keySet()){
            System.out.println("key: "+s+", value: "+map.get(s));
        }

    }

}
