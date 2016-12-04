package com.suite;

import com.connection_manager.UT_MySQLConnectionManager;
import com.connection_manager.UT_OracleDBConnectionManager;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({UT_MySQLConnectionManager.class, UT_OracleDBConnectionManager.class})
public class ManagerTestSuite {
    @BeforeClass
    public static void init(){
        System.out.println("Starting the suite:\n");
    }
}
