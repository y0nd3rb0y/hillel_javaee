package calc;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * Created by sam on 11/16/16.
 */
public class JMXAgent {
    public static void main(String[] args) throws MalformedObjectNameException,
            NotCompliantMBeanException,
            InstanceAlreadyExistsException,
            MBeanRegistrationException {
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        CalculatorModelMBean calculatorModelMBean = new CalculatorModel(1, 5);
        ObjectName objectName = new ObjectName("calc-jmx-test:name=first-mbean");
        platformMBeanServer.registerMBean(calculatorModelMBean, objectName);
        while(true){

        }
    }
}
