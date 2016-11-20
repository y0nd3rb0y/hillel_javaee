package client_manager_system;




import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ClientMSExecutor extends ThreadPoolExecutor{
    private Map<ClientRunnableEntry, Object> clientsInProgressMap = new ConcurrentHashMap();
    private BlockingQueue<ClientRunnableEntry> waitClientQueue = new LinkedBlockingQueue();

    public ClientMSExecutor() {
        //nThreads, nThreads,
        //0L, TimeUnit.MILLISECONDS,
          //      new LinkedBlockingQueue<Runnable>(),
            //    threadFactory
        //super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        super(4, 4, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        if (task == null) throw new NullPointerException();
        RunnableFuture<T> ftask = newTaskFor(task, result);

        ClientRunnableEntry clientRunnableEntry = new ClientRunnableEntry(ftask, result);
        if(clientsInProgressMap.containsKey(clientRunnableEntry)){
            waitClientQueue.add(clientRunnableEntry);
        } else {
            clientsInProgressMap.put(clientRunnableEntry, result);
            execute(clientRunnableEntry.getRf());
        }

        return ftask;
    }

    @Override
    protected void afterExecute(Runnable task, Throwable t) {

        if (t == null && task instanceof RunnableFuture) {
            try {
              Object result = ((Future<?>) task).get();
                ClientRunnableEntry clientRunnableEntry =
                        new ClientRunnableEntry((RunnableFuture) task, result);
                if (waitClientQueue.contains(clientRunnableEntry)) {
                    clientsInProgressMap.remove(clientRunnableEntry, result);
                    System.out.println("Client Task has finished");
                } else {
                    waitClientQueue.remove(clientRunnableEntry);
                    this.submit(clientRunnableEntry.getRf());
                }
            } catch (CancellationException ce) {
                t = ce;
            } catch (ExecutionException ee) {
                t = ee.getCause();
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt(); // ignore/reset

            if (t != null)
            System.out.println(t);
        }


        } else {
        }
    }


    class ClientRunnableEntry <T>{
        private RunnableFuture rf;
        private T client;

        public ClientRunnableEntry(RunnableFuture rf, T client) {
            this.rf = rf;
            this.client = client;
        }

        public RunnableFuture getRf() {
            return rf;
        }

        public void setRf(RunnableFuture rf) {
            this.rf = rf;
        }

        public T getClient() {
            return client;
        }

        public void setClient(T client) {
            this.client = client;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ClientRunnableEntry<?> that = (ClientRunnableEntry<?>) o;

            return client.equals(that.client);

        }

        @Override
        public int hashCode() {
            return client.hashCode();
        }
    }

}
