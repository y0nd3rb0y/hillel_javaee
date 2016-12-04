package com.connection;

public interface Connection {
    boolean establishConnection(Socket socket);
    boolean establishConnection(String strsocket);

    boolean close();

    Socket getSocket();
}
