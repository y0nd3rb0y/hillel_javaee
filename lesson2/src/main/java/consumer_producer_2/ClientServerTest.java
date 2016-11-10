package consumer_producer_2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by User on 10.11.2016.
 */
public class ClientServerTest {
    public static void main(String[] args) {
        BlockingQueue bucket = new ArrayBlockingQueue(10);
        Client client = new Client(bucket);
        Server server = new Server(bucket);
        client.start();
        server.start();
    }
}
