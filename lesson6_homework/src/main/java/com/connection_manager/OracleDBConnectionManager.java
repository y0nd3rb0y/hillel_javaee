package com.connection_manager;

import com.connection.Connection;
import com.database.Socket;

public class OracleDBConnectionManager implements ConnectionManager{
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public OracleDBConnectionManager(Connection connection) {
        this.connection = connection;
    }

    public OracleDBConnectionManager() {}

    public boolean establishConnection(Socket socket) {
        return false;
    }

    public boolean establishConnection(String customSocket){
        if(this.connection.establishConnection(customSocket)){
            return true;
        }
        return false;
    }
}
