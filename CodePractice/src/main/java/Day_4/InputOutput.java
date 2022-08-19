package Day_4;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class InputOutput {
    public static void firstInputOutputTask(String path){
        File file = new File(path);
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for (File f:
                 files) {
                System.out.println(f.getName());
            }

        } else{
            System.out.println("File is not a directory.");
        }
    }

    public static void secondInputOutputTask(String path){
        File folder = new File(path);
        File[] files = folder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if(name.toLowerCase().endsWith(".java")){
                    return true;
                }
                return false;
            }
        });

        for (File file:
             files) {
            System.out.println(file.getName());
        }
    }

    public static void thirdFourthFifthInputOutputTasks(String path){
        File file = new File(path);
        if(file.exists()){
            System.out.println("File exists.");
            if(file.canRead()){
                System.out.println(file.getName() + " has read permission.");
            } else{
                System.out.println(file.getName() + " does not have read permission.");
            }

            if(file.canWrite()){
                System.out.println(file.getName() + " has write permission.");
            } else{
                System.out.println(file.getName() + " does not have write permission.");
            }

            if(file.isDirectory()){
                System.out.println(file.getName() + " is a directory.");
            } else if(file.isFile()){
                System.out.println(file.getName() + " is a file.");
            }
        } else{
            System.out.println("File does not exist.");
        }
    }

    public static void sixthInputOutputTask(String path, String pathTwo){
        if(!path.endsWith(".txt") || !pathTwo.endsWith(".txt")){
            return;
        }
        File firstFile = new File(path);
        File secondFile = new File(pathTwo);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(firstFile));
            String firstFileContents = extractFileContents(reader);
            reader.close();
            reader = new BufferedReader(new FileReader(secondFile));
            String secondFileContents = extractFileContents(reader);

            System.out.println(firstFileContents.compareTo(secondFileContents));
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("File is not found.");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String extractFileContents(BufferedReader reader){
        StringBuffer fileContents = new StringBuffer();
        while(true){
            try {
                if (!reader.ready()) break;
                fileContents.append(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return fileContents.toString();
    }

    public static void seventhInputOutputTask(String path){
        File file = new File(path);
        System.out.println(file.lastModified());
    }

    public static void eigthInputOutputTask(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a number.");
        try {
            int number = Integer.parseInt(reader.readLine());
            System.out.println("Your number is " + number);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void ninthInputOutputTask(String path){
        Path newPath = Paths.get(path);
        try {
            long size = Files.size(newPath);
            System.out.println("File size in bytes: " + size);
            System.out.println("File size in kilobytes: " + size / 1024);
            System.out.println("File size in megabytes: " + size / (1024 * 1024));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void tenthInputOutputTask(String path){
        Path p = Paths.get(path);
        try {
            byte[] array = Files.readAllBytes(p);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void eleventhInputOutputTask(String path){
        File file = new File(path);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            ArrayList<String> data = new ArrayList<>();

            while(reader.ready()){
                data.add(reader.readLine());
            }
            reader.close();
            System.out.println(data);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<String> thirteenthInputOutputTask(String path){
        File file = new File(path);
        ArrayList<String> data = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while(reader.ready()){
            data.add(reader.readLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public static void sixteenthInputOutputTask(String inputFilename, String outputFilename){
        ArrayList<String> data = thirteenthInputOutputTask(inputFilename);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilename));
            for (String line:
                 data) {
                writer.append(line);
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void eighteenthInoutOutputTask(String path){
        ArrayList<String> data = thirteenthInputOutputTask(path);
        String longestWord = "";

        for(int i = 0; i < data.size(); i++){
            String line = data.get(i);
            String[] words = line.split(" ");
            for(int j = 0; j < words.length; j++){
                if(words[j].length() > longestWord.length()){
                    longestWord = words[j];
                }
            }
        }
        System.out.println(longestWord);
    }

}
