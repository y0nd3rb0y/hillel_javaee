package com.suite;

import com.connection.UT_Connection;
import com.connection.UT_Socket;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({UT_Connection.class, UT_Socket.class})
public class NetworkTestSuite {
}
