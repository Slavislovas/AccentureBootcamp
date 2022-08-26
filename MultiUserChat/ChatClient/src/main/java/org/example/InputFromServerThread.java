package org.example;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputFromServerThread extends Thread{
    private InputStream serverIn;

    public InputFromServerThread(InputStream serverIn){
        this.serverIn = serverIn;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(serverIn));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                System.out.printf(line);
            }
        } catch (Exception e){

        }
    }
}
