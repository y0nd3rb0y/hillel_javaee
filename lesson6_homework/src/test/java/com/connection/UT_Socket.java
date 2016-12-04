package com.connection;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class UT_Socket {
    private Socket socket;
    private Connection connection;
    @Before
    public void setup(){
        socket = mock(Socket.class);
        connection = mock(Connection.class);
    }

    @Test
    public void testSocket(){
        when(connection.establishConnection(socket)).thenReturn(true);
        when(socket.validateConnection(connection)).thenReturn(true);
        when(socket.getConnection()).thenReturn(connection);
        Assert.assertEquals(socket.validateConnection(socket.getConnection()), true);
    }


}
