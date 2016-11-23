package client_manager_system;

import java.util.concurrent.Callable;

public class ClientTask implements Runnable {
    private Client client;

    public ClientTask(Client client) {
        this.client = client;
    }

    public void run() {
        System.out.println("Client:: " + client);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Client getClient() {
        return client;
    }

    @Override
    public String toString() {
        return "ClientTask{" +
                "client=" + client.getId() +
                '}';
    }
}
