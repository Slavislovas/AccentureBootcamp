package Day_4;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTasks {
    public static void firstTaskArrayList(){
        ArrayList<String> list = new ArrayList<>();
        list.add("red");
        list.add("blue");
        list.add("yellow");
        list.add("green");
        list.add("magenta");
        System.out.println(list.toString());
    }

    public static void secondTaskArrayList(String element){
        ArrayList<String> list = new ArrayList<>();
        list.add("red");
        list.add("blue");
        list.add("yellow");
        list.add("green");
        list.add("magenta");

        list.add(0, element);
        System.out.println(list.toString());

    }

    public static void thirdTaskArrayList(){
        ArrayList<String> firstList = new ArrayList<>();
        firstList.add("red");
        firstList.add("blue");
        firstList.add("yellow");
        firstList.add("green");
        firstList.add("magenta");
        ArrayList<String> secondList = new ArrayList<>();
        for (int i = 0; i < firstList.size(); i++){
            secondList.add(firstList.get(i));
        }
        System.out.println(secondList.toString());
    }

    public static void fourthTaskArrayList(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Collections.shuffle(list);
        System.out.println(list.toString());
    }

    public static void fifthTaskArrayList(){
        ArrayList<String> list = new ArrayList<>();
        list.add("red");
        list.add("blue");
        list.add("yellow");
        list.add("green");
        list.add("magenta");
        ArrayList<String> secondList = new ArrayList<>();
        secondList = (ArrayList<String>) list.clone();
        System.out.println(secondList.toString());
    }

}
