package org.example;

import java.io.*;

public class OutputToServerThread extends Thread{
    private OutputStream serverOut;

    public OutputToServerThread(OutputStream serverOut){
        this.serverOut = serverOut;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                serverOut.write(line.getBytes());
                System.out.printf(line);
            }
        } catch (Exception e){
        }
    }
}
