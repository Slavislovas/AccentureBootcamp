package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Server extends Thread{
    private int port;
    private Connection databaseConnection;

    private List<ServerThread> threads;
    public Server(int port, Connection databaseConnection) {
        this.port = port;
        this.databaseConnection = databaseConnection;
        this.threads = new ArrayList<>();
    }

    public List<ServerThread> getThreads(){
        return this.threads;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while(true){
                Socket clientSocket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(clientSocket, databaseConnection, this);
                serverThread.start();
                threads.add(serverThread);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
