package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer{


    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");
                ChatServerThread clientThread = new ChatServerThread(clientSocket);
                clientThread.start();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
