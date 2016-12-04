package com.connection_manager;


import com.connection.Connection;
import com.connection.Socket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MySQLConnectionManager implements ConnectionManager {

    @Autowired
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public MySQLConnectionManager(Connection connection) {
        this.connection = connection;
    }

    public MySQLConnectionManager() {}

    public boolean establishConnection(Socket socket){
        return connection.establishConnection(socket);
    }

    public boolean establishConnection(String string) {
        return false;
    }

}
