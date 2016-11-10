package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by User on 10.11.2016.
 */
public class ServerCustomSocket {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket clientSocket = serverSocket.accept();
        Scanner scanner = new Scanner(System.in);
        BufferedReader clientReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream());
        printWriter.println("Hello from Server");
        printWriter.flush();
        String msgFromClient;
        while(!"stop".equals(msgFromClient = clientReader.readLine())){
            System.out.println("msg from client = " + msgFromClient);
            String serverMsg = scanner.nextLine();
            printWriter.println(serverMsg);
            printWriter.flush();
        }
    }
}
