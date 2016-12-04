package com.connection_manager;


import com.connection.Socket;

public interface ConnectionManager {
    boolean establishConnection(Socket Socket);
    boolean establishConnection(String string);
}
