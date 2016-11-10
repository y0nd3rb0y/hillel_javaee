package consumer_producer;

/**
 * Created by User on 10.11.2016.
 */
public class Bucket {
    private int number;
    private boolean isAvailable;

    synchronized public int getNumber() throws InterruptedException {
        if(!isAvailable) {
            wait();
        }
        isAvailable = false;
        notifyAll();
        return number;
    }

    synchronized public void setNumber(int number) throws InterruptedException {
        if(isAvailable){
            wait();
        }

        this.number = number;
        this.isAvailable = true;
        notifyAll();
    }
}
