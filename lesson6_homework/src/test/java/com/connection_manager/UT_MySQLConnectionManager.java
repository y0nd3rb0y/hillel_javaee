package com.connection_manager;

import com.connection.Connection;
import com.database.Socket;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UT_MySQLConnectionManager {
    private Connection connection;
    private Socket socket;
    private MySQLConnectionManager mySQLConnectionManager;

    @Before
    public void setup(){
        connection = mock(Connection.class);
        socket = mock(Socket.class);
        mySQLConnectionManager = mock(MySQLConnectionManager.class);

    }

    @Test
    public void testEstablishConnection(){
        when(mySQLConnectionManager.establishConnection(socket)).thenReturn(true);
        when(mySQLConnectionManager.establishConnection("123.123.123.123")).thenReturn(false);
        when(mySQLConnectionManager.getConnection()).thenReturn(connection);
        when(connection.getSocket()).thenReturn(socket);

        Assert.assertEquals(true, mySQLConnectionManager.establishConnection(socket));
        Assert.assertEquals(mySQLConnectionManager.getConnection().getSocket(), socket);

        Assert.assertEquals(mySQLConnectionManager.establishConnection("123.123.123.123"), false);

    }

}
