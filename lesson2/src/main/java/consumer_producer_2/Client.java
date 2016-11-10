package consumer_producer_2;

import consumer_producer.Bucket;

import java.util.concurrent.BlockingQueue;

/**
 * Created by User on 10.11.2016.
 */
public class Client extends Thread {
    private BlockingQueue<Integer> bucket;

    public Client(BlockingQueue<Integer> bucket) {
        this.bucket = bucket;
    }

    public void run(){
        try {
            for (int i = 0; i < 10; i++) {
                int number = bucket.take();
                System.out.println("client gets: " + number);
                Thread.sleep(100);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
