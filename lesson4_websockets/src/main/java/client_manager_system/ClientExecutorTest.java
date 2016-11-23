package client_manager_system;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ClientExecutorTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ClientMSExecutor clientMSExecutor = new ClientMSExecutor();
        Client client1 = new Client(1, "x0", "x0");
        client1.setId(1);


        for (int i = 0; i < 10; i++) {
            ClientTask clientTask = new ClientTask(client1);
            Future<String> submit = clientMSExecutor.submit(clientTask, "");
            System.out.println("task " + i + " started ");


        }
    }
}
