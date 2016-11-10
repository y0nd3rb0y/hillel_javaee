package consumer_producer_2;

/**
 * Created by User on 10.11.2016.
 */
public class ClientServerTest {
    public static void main(String[] args) {
        Bucket bucket = new Bucket();
        Client client = new Client(bucket);
        Server server = new Server(bucket);
        client.start();
        server.start();
    }
}
