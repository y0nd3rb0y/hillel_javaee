package jmx_test;

/**
 * Created by User on 14.11.2016.
 */
public interface SystemManagerMBean {
    int getThreadCount();

    void setThreadCount(int threadCount);

    void doSomething();
}
