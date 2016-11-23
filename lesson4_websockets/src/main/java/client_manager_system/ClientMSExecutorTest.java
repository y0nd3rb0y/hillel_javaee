package client_manager_system;

import java.util.Arrays;
import java.util.List;

public class ClientMSExecutorTest {
    public static void main(String[] args) {
        List<Client> clients = Arrays.asList(new Client(1, "x1", "x1"),
                new Client(1, "x2", "x2"),
                new Client(1, "x3", "x3"),
                new Client(1, "x4", "x4"),
                new Client(1, "x5", "x5"),
                new Client(1, "x6", "x6"));

        List<ClientTask> clientTaskList = Arrays.asList(
                new ClientTask(clients.get(0)),
                new ClientTask(clients.get(1)),
                new ClientTask(clients.get(1)),
                new ClientTask(clients.get(2)),
                new ClientTask(clients.get(4))

                );

        ClientMSExecutor clientMSExecutor = new ClientMSExecutor();
        for(ClientTask clientTask : clientTaskList){
            clientMSExecutor.submit(clientTask, clientTask.getClient());
        }
    }

}
