package jmx_test;

/**
 * Created by User on 14.11.2016.
 */
public class SystemManager implements SystemManagerMBean {
    private int threadCount;

    public int getThreadCount() {
        System.out.println("get -> threadcount = " +threadCount);
        return threadCount;
    }

    public void setThreadCount(int threadCount) {
        System.out.println("set -> threadcount = " + threadCount);
        this.threadCount = threadCount;
    }

    public void doSomething(){
        System.out.println("I'm doing smth");
    }

}
