package Day_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTasks {
    public static void firstLinkedListTask(){
        LinkedList<String> list = new LinkedList<>();
        list.add("red");
        list.add("blue");
        list.add("yellow");
        list.add("magenta");

        Iterator iterator = list.descendingIterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static void secondLinkedListTask(int index, String element){
        LinkedList<String> list = new LinkedList<>();
        list.add("red");
        list.add("blue");
        list.add("yellow");
        list.add("magenta");

        list.add(index, element);
        System.out.println(list.toString());
    }

    public static void thirdLinkedListTask(){
        LinkedList<String> list = new LinkedList<>();
        list.add("red");
        list.add("blue");
        list.add("yellow");
        list.add("magenta");

        LinkedList<String> secondList = new LinkedList<>();
        secondList.add("first");
        secondList.add("second");

        LinkedList<String> thirdList = new LinkedList<>();
        thirdList.addAll(list);
        thirdList.addAll(secondList);
    }

    public static void fourthLinkedListTask(){
        LinkedList<String> list = new LinkedList<>();

        if(list.isEmpty()){
            System.out.println("Linked list is empty.");
        } else{
            System.out.println("Linked list is not empty.");
        }
    }

    public static void fifthLinkedListTask(){
        LinkedList<String> list = new LinkedList<>();
        list.add("red");
        list.add("blue");
        list.add("yellow");
        list.add("magenta");

        ArrayList<String> arrayList = new ArrayList<>(list);
        System.out.println(arrayList);
    }
}
