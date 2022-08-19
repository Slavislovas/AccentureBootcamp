package Day_4;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTasks {

    public static void firstTreeMapTask(String key, int value){
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put(key, value);
    }
    public static void secondTreeMapTask(){
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("A", 1);
        map.put("B", 1);
        map.put("C", 1);
        map.put("D", 1);
        Object[] set = map.keySet().toArray();

        for(int i = set.length - 1; i >= 0; i--){
            System.out.println(set[i]);
        }
    }

    public static void thirdTreeMapTask(String key){
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("A", 1);
        map.put("B", 1);
        map.put("C", 1);
        map.put("D", 1);
        System.out.println(map.floorEntry(key));
    }

    public static void fourthTreeMapTask(String key){
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("A", 1);
        map.put("B", 1);
        map.put("C", 1);
        map.put("D", 1);

        System.out.println(map.lowerKey(key));

    }

    public static void fifthTreeMapTask(){
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("A", 1);
        map.put("B", 1);
        map.put("C", 1);
        map.put("D", 1);

        String key = map.lastKey();
        map.remove(key);
        System.out.println(map.toString());
    }
}
