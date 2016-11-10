package consumer_producer;

/**
 * Created by User on 10.11.2016.
 */
public class Client extends Thread {
    private Bucket bucket;

    public Client(Bucket bucket) {
        this.bucket = bucket;
    }

    public void run(){
        try {
            for (int i = 0; i < 10; i++) {
                int number = bucket.getNumber();
                System.out.println("client gets: " + number);
                Thread.sleep(100);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
