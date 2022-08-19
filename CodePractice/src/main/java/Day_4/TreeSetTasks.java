package Day_4;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTasks {
    public static void firstTreeSetTask(){
        TreeSet<Integer> set = new TreeSet<>();
        set.add(65);
        set.add(6100);
        set.add(1);
        set.add(2);
        set.add(3);

        Iterator iterator = set.iterator();

        while(iterator.hasNext()){
            int element = (int)iterator.next();
            if(element < 7){
                System.out.println(element);
            }
        }
    }

    public static void secondTreeSetTask(int element){
        TreeSet<Integer> set = new TreeSet<>();
        set.add(20);
        set.add(10);
        set.add(1);
        set.add(2);
        set.add(3);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            int e = (int)iterator.next();
            if(e >= element){
                System.out.println(e);
            }
        }
    }

    public static void thirdTreeSetTask(){
        TreeSet<Integer> set = new TreeSet<>();
        set.add(20);
        set.add(10);
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set.toString());
        System.out.println(set.first());
        set.remove(set.first());
        System.out.println(set.toString());
    }

    public static void fourthTreeSetTask(){
        TreeSet<Integer> set = new TreeSet<>();
        set.add(20);
        set.add(10);
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set.toString());
        System.out.println(set.last());
        set.remove(set.last());
        System.out.println(set.toString());
    }

    public static void fifthTreeSetTask(int element){
        TreeSet<Integer> set = new TreeSet<>();
        set.add(20);
        set.add(10);
        set.add(1);
        set.add(2);
        set.add(3);
        if(set.remove(element)){
            System.out.println(set.toString());
        } else{
            System.out.println("Failed to remove element.");
        }
    }
}
