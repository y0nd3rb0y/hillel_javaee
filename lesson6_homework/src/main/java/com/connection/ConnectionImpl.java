package com.connection;

import com.database.Socket;
import org.springframework.stereotype.Repository;

@Repository
public class ConnectionImpl implements Connection{
    private Socket socket;

    public boolean establishConnection(Socket socket) {
        socket.setConnection(this);
        return socket.validateConnection(this);
    }

    public boolean establishConnection(String customSocket) {
        this.setSocket(new Socket(this));
        socket.setSocket(customSocket);
        return  socket.validateConnection(this);

    }

    public boolean close() {
        return true;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "socket=" + socket +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConnectionImpl that = (ConnectionImpl) o;

        return socket.equals(that.socket);

    }

    @Override
    public int hashCode() {
        return socket.hashCode();
    }
}
