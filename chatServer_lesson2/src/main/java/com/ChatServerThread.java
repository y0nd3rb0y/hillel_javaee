package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatServerThread extends Thread {
    private Socket clientSocket;
    public ChatServerThread(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    public void run(){
        BufferedReader clientReader = null;
        try {
            clientReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream());
            printWriter.println("Hello from Server");
            printWriter.flush();
            String msgFromClient;
            while(!"bye".equals(msgFromClient = clientReader.readLine())){
                System.out.println("msg from client = " + msgFromClient);
                printWriter.println(msgFromClient);
                printWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() throws IOException
    {
        if (clientSocket != null) {
            clientSocket.close();
        }
    }


}
