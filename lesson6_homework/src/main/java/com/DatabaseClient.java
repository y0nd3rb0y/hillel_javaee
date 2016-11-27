package com;

import com.connection.Connection;
import com.connection.ConnectionImpl;
import com.connection_manager.ConnectionManager;
import com.connection_manager.MySQLConnectionManager;
import com.connection_manager.OracleDBConnectionManager;
import com.database.Socket;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DatabaseClient {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        ConnectionManager connectionManager = context.getBean("mySQLConnectionManager", MySQLConnectionManager.class);
        if(connectionManager.establishConnection("127.0.0.1:8888")){
            System.out.println("Connection established with MySQL database");
        } else {
            connectionManager = context.getBean("oracleDBConnectionManager", OracleDBConnectionManager.class);
            if(connectionManager.establishConnection(new Socket())){
                System.out.println("Connection established with MySQL database");
            } else {
                System.out.println("Connection failed");
            }
        }
    }


}
