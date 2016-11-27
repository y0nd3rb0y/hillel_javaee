package com.connection_manager;


import com.connection.Connection;
import com.connection.ConnectionImpl;
import com.database.Socket;

public class MySQLConnectionManager implements ConnectionManager {
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
        if(connection.establishConnection(socket)){
            return true;
        }
        return false;
    }

    public boolean establishConnection(String string) {
        return false;
    }

}
