package com.connection;

import com.database.Socket;

public interface Connection {
    boolean establishConnection(Socket socket);
    boolean establishConnection(String strsocket);

}
