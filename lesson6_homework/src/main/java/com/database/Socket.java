package com.database;

import com.connection.Connection;
import com.connection.ConnectionImpl;

public class Socket {


    private String socket;

    private Connection connection;

    public Socket() {}

    public Socket(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public boolean validateConnection(Connection connection){
        if(this.getConnection().equals(connection)){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Socket{" +
                "socket='" + socket + '\'' +
                '}';
    }
}
