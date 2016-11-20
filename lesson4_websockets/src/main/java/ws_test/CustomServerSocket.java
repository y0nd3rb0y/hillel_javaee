package ws_test;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/chat")
public class CustomServerSocket {

    @OnOpen
    public void onConnect(Session session){
        System.out.println("server:: connection is available");
    }

    @OnMessage
    public String onMessage(Session session, String message) throws IOException {
        System.out.println("server:: message -> " + message);
        if("exit".equals(message)){
            session.close(new CloseReason(CloseReason.CloseCodes.NORMAL_CLOSURE, "exit"));
        }
        return message;
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason){
        System.out.println("server:: disconnected by " + closeReason.getReasonPhrase());
    }


}
