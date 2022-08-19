package Day_4;

import Day_3.PickupTruck;

import java.util.*;

public class HashSetTasks {
    public static void firstHashSetTask(){
        HashSet<String> set = new HashSet<>();
        set.add("blue");
        set.add("red");
        set.add("yellow");
        set.add("green");

        for (String string : set){
            System.out.println(string);
        }
    }

    public static void secondHashSetTask(){
        HashSet<String> set = new HashSet<>();
        set.add("blue");
        set.add("red");
        set.add("yellow");
        set.add("green");

        for (String string : set){
            System.out.println(string);
        }
        System.out.println("Let's empty the set");
        set.clear();
        for (String string : set){
            System.out.println(string);
        }
    }

    public static void thirdHashSetTask(){
        HashSet<String> set = new HashSet<>();
        set.add("blue");
        set.add("red");
        set.add("yellow");
        set.add("green");

        TreeSet<String> secondSet = new TreeSet<>(set);
        System.out.println(secondSet.toString());
    }

    public static void fourthHashSetTask(){
        HashSet<String> set = new HashSet<>();
        set.add("blue");
        set.add("red");
        set.add("yellow");
        set.add("green");

        HashSet<String> secondSet = new HashSet<>();

        set.retainAll(secondSet);
        System.out.println(set);

    }

    public static void fifthHashSetTask(){
        HashSet<String> set = new HashSet<>();
        set.add("blue");
        set.add("red");
        set.add("yellow");
        set.add("green");

        ArrayList<String> list = new ArrayList<>(set);
    }

}
