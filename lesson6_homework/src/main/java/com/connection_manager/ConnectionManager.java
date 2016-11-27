package com.connection_manager;


import com.database.Socket;

public interface ConnectionManager {
    boolean establishConnection(Socket Socket);
    boolean establishConnection(String string);
}
