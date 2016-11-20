package ws_test;

import org.glassfish.tyrus.client.ClientManager;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.DeploymentException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

@ClientEndpoint
public class CustomClientSocket {
    @OnOpen
    public void onConnect(Session session) throws IOException {
        System.out.println("client:: session is open");
        session.getBasicRemote().sendText("Hello from client");
    }
    @OnMessage
    public String onMessage(Session session, String message){
        System.out.println("client:: message -> " + message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason){
        System.out.println("client:: disconnected by " + closeReason.getReasonPhrase());
    }

    public static void main(String[] args) throws URISyntaxException, DeploymentException, InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        //new CustomClientSocket();
        ClientManager clientManager = new ClientManager();
        clientManager.connectToServer(CustomClientSocket.class, new URI("ws://localhost:9090/websockets/chat"));
        countDownLatch.await();
    }
}
