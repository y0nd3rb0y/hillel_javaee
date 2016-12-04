package com.custom_runner;

import com.connection.UT_Connection;
import com.connection.UT_Socket;
import com.connection_manager.UT_MySQLConnectionManager;
import com.connection_manager.UT_OracleDBConnectionManager;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;

import java.io.FileWriter;
import java.io.IOException;

public class JUnitCoreRunner extends Runner {

    public static void main(String[] args) {

        try {

            Class[] testClasses = {UT_Socket.class,
                    UT_OracleDBConnectionManager.class,
                    UT_MySQLConnectionManager.class};
            JUnitCore jUnitCore = new JUnitCore();
            jUnitCore.addListener(new CustomRunListener());
            jUnitCore.run(testClasses);
        } catch (Exception e) {
        }
    }


    public Description getDescription() {
        return null;
    }

    public void run(RunNotifier notifier) {
        try {
            notifier.addListener(new CustomRunListener());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
