package org.example;

import com.mysql.jdbc.Driver;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ServerMain {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat", "root", "");
            Server server = new Server(8080, databaseConnection);
            server.start();
        } catch (SQLException e){
        }
    }
}