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
import java.util.concurrent.locks.ReentrantLock;

public class ClientMSExecutor extends ThreadPoolExecutor{
    private Map<ClientRunnableEntry, Object> clientsInProgressMap = new ConcurrentHashMap();
    private BlockingQueue<ClientRunnableEntry> waitClientQueue = new LinkedBlockingQueue();
    private ReentrantLock lock = new ReentrantLock();

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
        try {
            lock.lock();
            Object client = null;
            ClientRunnableEntry clientInProgress = null;
            for (ClientRunnableEntry clientRunnableEntry : clientsInProgressMap.keySet()) {
                if (task.equals(clientRunnableEntry.getRf())) {
                    client = clientRunnableEntry.client;
                    clientInProgress = clientRunnableEntry;
                    clientsInProgressMap.remove(clientInProgress);
                    System.out.println("Remove from main clientInProgressMap" + client);
                    break;
                }
            }

            for (ClientRunnableEntry clientRunnableEntry : waitClientQueue) {
                if (clientRunnableEntry.equals(clientInProgress)) {
                    waitClientQueue.remove(clientRunnableEntry);
                    clientsInProgressMap.put(clientRunnableEntry, client);
                    System.out.println("Remove from waitClientQueue" + client);
                    execute(clientRunnableEntry.getRf());

                }
            }

        } finally {
            lock.unlock();
        }
        /*if (t == null && task instanceof RunnableFuture) {  //мой вариант
            try {
              Object result = ((Future<?>) task).get();
                ClientRunnableEntry clientRunnableEntry =
                        new ClientRunnableEntry((RunnableFuture) task, result);
                clientsInProgressMap.remove(clientRunnableEntry, result);
                if (waitClientQueue.contains(clientRunnableEntry)) {
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
        }*/
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
