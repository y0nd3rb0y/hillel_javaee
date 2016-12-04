package com.connection;


import com.custom_runner.CustomRunner;
import com.custom_runner.JUnitCoreRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(JUnitCoreRunner.class)
public class UT_Connection {
    private Connection connection;
    private Socket socket;
    @Before
    public void setup(){
        connection = mock(Connection.class);
        socket = mock(Socket.class);
    }

    @Test
    public void testEstablishConnection(){
        when(connection.establishConnection(socket)).thenReturn(true);
        when(connection.getSocket()).thenReturn(socket);
        Assert.assertEquals(connection.getSocket(), socket);

    }

    @Test
    public void testClose(){
        given(connection.close()).willReturn(true);
    }
}
