package ExtraLearning;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input how many elements of the array you want to print");
        int loopAmount = Integer.parseInt(reader.readLine());
        Main.method1(loopAmount);

        //Main.callInputMethod();
    }

    public static void method1(int loopAmount){
        int[] array = {1, 2, 3, 5, 10};
        method2(array, loopAmount);
    }

    //Can throw an unchecked exception
    public static void method2(int[] array, int loopAmount) {
            for(int i = 0; i < loopAmount; i++){
                System.out.println(array[i]);
            }
    }

    public static void callInputMethod() {
        String filePath = "C:\\Users\\Martynas\\Desktop\\data.txt";
        Main.inputMethod(filePath);
    }

    //Can throw checked exception
    public static void inputMethod(String filePath) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            String[] splitLine = line.split(";");

            for (String word :
                    splitLine) {
                System.out.println(word);
            }
            reader.close();
        } catch(IOException e){
            System.out.println("test");
        }
    }

}
