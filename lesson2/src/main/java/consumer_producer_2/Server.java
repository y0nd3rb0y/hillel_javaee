package consumer_producer_2;

import java.util.concurrent.BlockingQueue;

/**
 * Created by User on 10.11.2016.
 */
public class Server extends Thread {
    private BlockingQueue bucket;

    public Server(BlockingQueue bucket) {
        this.bucket = bucket;
    }

    public void run(){
        try {
            for (int i = 0; i < 10; i++) {
                bucket.put(i);
                System.out.println("server set " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
