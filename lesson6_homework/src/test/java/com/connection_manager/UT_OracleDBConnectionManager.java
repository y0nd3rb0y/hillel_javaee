package com.connection_manager;

import com.connection.Connection;
import com.database.Socket;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UT_OracleDBConnectionManager {
    private Connection connection;
    private Socket socket;
    private OracleDBConnectionManager oracleDBConnectionManager;

    @Before
    public void setup(){
        connection = mock(Connection.class);
        socket = mock(Socket.class);
        oracleDBConnectionManager = mock(OracleDBConnectionManager.class);

    }

    @Test
    public void testEstablishConnection(){
        when(oracleDBConnectionManager.establishConnection(socket)).thenReturn(false);
        when(oracleDBConnectionManager.establishConnection("123.123.123.123")).thenReturn(true);
        when(oracleDBConnectionManager.getConnection()).thenReturn(connection);
        when(connection.getSocket()).thenReturn(socket);

        Assert.assertEquals(false, oracleDBConnectionManager.establishConnection(socket));
        Assert.assertEquals(oracleDBConnectionManager.getConnection().getSocket(), socket);

        Assert.assertEquals(oracleDBConnectionManager.establishConnection("123.123.123.123"), true);

    }
}
