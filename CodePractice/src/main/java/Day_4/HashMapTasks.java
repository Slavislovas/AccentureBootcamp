package Day_4;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class HashMapTasks {
    public static void firstHashMapTask(String key, int value){
        HashMap<String, Integer> map = new HashMap<>();
        map.put(key, value);
        System.out.println(map.toString());
    }

    public static void secondHashMapTask(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("key", 100);
        System.out.println(map.toString());
        System.out.println(map.size());
    }

    public static void thirdHashMapTask(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("key", 100);
        map.put("secondKey", 1651);
        map.put("thirdKey", 351);
        map.put("fourthKey", 123);
        System.out.println(map.toString());
        HashMap<String, Integer> secondMap = new HashMap<>();
        secondMap.putAll(map);
        System.out.println(secondMap.toString());
    }

    public static void fourthHashMapTask(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("key", 100);
        map.put("secondKey", 1651);
        map.put("thirdKey", 351);
        map.put("fourthKey", 123);
        map.clear();
        System.out.println(map.toString());
    }

    public static void fifthHashMapTask(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("key", 100);
        map.put("secondKey", 1651);
        map.put("thirdKey", 351);
        map.put("fourthKey", 123);
        Collection collection = map.values();
        System.out.println(collection.toString());
    }
}
