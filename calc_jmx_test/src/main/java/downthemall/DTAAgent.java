package downthemall;

import com.sun.media.jfxmediaimpl.platform.PlatformManager;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * Created by sam on 11/16/16.
 */
public class DTAAgent {
    public static void main(String[] args) throws MalformedObjectNameException,
            NotCompliantMBeanException,
            InstanceAlreadyExistsException,
            MBeanRegistrationException,
            InterruptedException {
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        DownThemAllMBean downThemAllMBean = new DownThemAll("https://www.google.com.ua", "test.html");
        ObjectName objectName = new ObjectName("downthemall:name=http-get-bean");
        platformMBeanServer.registerMBean(downThemAllMBean, objectName);
        Thread.sleep(Long.MAX_VALUE);
    }
}
