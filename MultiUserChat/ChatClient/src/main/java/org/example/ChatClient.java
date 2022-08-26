package org.example;

import java.io.*;
import java.net.Socket;

public class ChatClient {
    private Socket socket;
    private int serverPort;
    private String serverName;
    private OutputStream serverOut;
    private InputStream serverIn;
    //This is not working :(
    public ChatClient(int serverPort, String serverName) {
        this.serverPort = serverPort;
        this.serverName = serverName;
    }

    public static void main(String[] args) throws IOException {
        ChatClient chatClient = new ChatClient(8080, "localhost");
        if(chatClient.connect()){
            System.out.println("Connection successful");

        } else{
            System.out.printf("Connection failed");
        }
    }


    private boolean connect(){
        try {
            Socket socket = new Socket(serverName, serverPort);
            this.serverOut = socket.getOutputStream();
            this.serverIn = socket.getInputStream();
            InputFromServerThread inputFromServerThread = new InputFromServerThread(serverIn);
            OutputToServerThread outputToServerThread = new OutputToServerThread(serverOut);
            inputFromServerThread.start();
            outputToServerThread.start();
            return true;

        } catch (IOException e) {
            return false;
        }
    }
}