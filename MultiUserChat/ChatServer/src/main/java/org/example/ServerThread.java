package org.example;
import java.io.*;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.sql.*;

public class ServerThread extends Thread{
    private Socket clientSocket;
    private Connection databaseConnection;
    private DataController dataController;
    private String login = null;
    private Server server;
    private OutputStream clientOutputStream;

    public ServerThread(Socket clientSocket, Connection databaseConnection, Server server){
        this.clientSocket = clientSocket;
        this.databaseConnection = databaseConnection;
        this.dataController = new DataController(databaseConnection);
        this.server = server;
    }

    public String getLogin(){
        return login;
    }

    @Override
    public void run() {
        handleClientSocket();
    }

    private void handleClientSocket(){
        try {
            InputStream clientInputStream = clientSocket.getInputStream();
            this.clientOutputStream = clientSocket.getOutputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientInputStream));
            String line;

            while((line = reader.readLine()) != null){
                String[] tokens = line.split(" ");
                if(tokens != null && tokens.length > 0) {
                    String cmd = tokens[0];
                    if ("quit".equalsIgnoreCase(line)) {
                        break;
                    } else if ("login".equalsIgnoreCase(cmd) && tokens.length == 3) {
                        if(login != null){
                            clientOutputStream.write("You are already logged in!\n".getBytes());
                        }
                        else{
                            handleLogin(tokens, clientOutputStream);
                        }
                    } else if ("register".equalsIgnoreCase(cmd) && tokens.length == 3) {
                        handleRegistration(tokens, clientOutputStream);

                    }  else if("message".equalsIgnoreCase(cmd) && tokens.length >= 3){
                        if(login != null){
                            handleMessageSending(tokens, clientOutputStream);
                        } else{
                            clientOutputStream.write("You need to login before sending messages".getBytes());
                        }
                    }else {
                        clientOutputStream.write(("Unknown command: " + cmd + "\n").getBytes());
                    }
                }
            }
            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void handleMessageSending(String[] tokens, OutputStream clientOutputStream) {
        List<ServerThread> threads = server.getThreads();
        try {
            if (Objects.equals(tokens[1], "public")) {
                for (ServerThread st :
                        threads) {
                    st.send(login + "(public): " + joinTokens(tokens, 2, tokens.length));
                }
            } else if (Objects.equals(tokens[1], "private")) {
                boolean isOnline = false;
                for (ServerThread st :
                threads) {
                    if(Objects.equals(st.login, tokens[2])){
                        st.send(login + "(private): " + joinTokens(tokens, 3, tokens.length));
                        send(login + "(private): " + joinTokens(tokens, 3, tokens.length));
                        isOnline = true;
                    }
                }
                if(!isOnline){
                    send("User: " + tokens[2] + " is not currently online\n");
                }
            }
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    private String joinTokens(String[] tokens, int fromIndex, int toIndex) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = fromIndex; i < toIndex; i++){
            stringBuffer.append(tokens[i]+" ");
        }
        stringBuffer.append("\n");
        return stringBuffer.toString();
    }

    private void handleRegistration(String[] tokens, OutputStream clientOutputStream) {
        String login = tokens[1];
        String password = tokens[2];
        try {
            if (dataController.insertUser(login, password)) {
                clientOutputStream.write("You have been successfully registered\n".getBytes());
            } else {
                clientOutputStream.write("Username is taken\n".getBytes());
            }
        } catch (RuntimeException e){

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void handleLogin(String[] tokens, OutputStream clientOutputStream) {
        try {
                String login = tokens[1];
                String password = tokens[2];
                if (dataController.checkLogin(login, password)) {
                    this.login = login;
                    List<ServerThread> threads = server.getThreads();
                    for (ServerThread st:
                         threads) {
                        st.send("User: " + this.login + " has logged in\n");
                    }
                } else{
                    clientOutputStream.write("Incorrect login or password!\n".getBytes());
                }
        } catch (Exception e){

        }
    }

    private void send(String message) throws IOException {
        if(login != null){
            clientOutputStream.write(message.getBytes());
        }
    }
}
