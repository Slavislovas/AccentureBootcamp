package Day_4;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueTasks {
    public static void firstPriorityQueueTask() {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("first");
        queue.add("second");
        queue.add("third");
        queue.add("fourth");

        Iterator iterator = queue.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void secondPriorityQueueTask() {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("first");
        queue.add("second");
        queue.add("third");
        queue.add("fourth");

        String[] array = queue.toArray(new String[0]);
        for (String line : array) {
            System.out.println(line);
        }
    }

    public static void thirdPriorityQueueTask() {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("first");
        queue.add("second");
        queue.add("third");
        queue.add("fourth");

        System.out.println(queue.toString());
        queue.clear();
        System.out.println(queue.toString());
    }

    public static void fourthPriorityQueueTask(){
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("first");
        queue.add("second");
        queue.add("third");
        queue.add("fourth");
        System.out.println("Elements in queue: " + queue.size());
    }

    public static void fifthPriorityQueueTask(){
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("first");
        queue.add("second");
        queue.add("third");
        queue.add("fourth");
        System.out.println(queue.toString());
        queue.poll();
        System.out.println(queue.toString());
    }

}
