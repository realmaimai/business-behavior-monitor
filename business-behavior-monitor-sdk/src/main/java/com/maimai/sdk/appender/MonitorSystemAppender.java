package com.maimai.sdk.appender;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import com.maimai.sdk.model.LogMessage;
import com.maimai.sdk.push.IPush;
import com.maimai.sdk.push.RedisPush;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class MonitorSystemAppender<E> extends AppenderBase<E> {
    private Logger logger = LoggerFactory.getLogger(MonitorSystemAppender.class);
    // config for logging if this sdk is going to let other team to use
    private String systemName;
    private String groupId; // groupId that we want to monitor
    private String host; // redis host
    private int port; // redis port
    private IPush push;


    @Override
    public void start() {
        if (null == systemName || systemName.isEmpty()) {
            throw new IllegalArgumentException("system name cannot be empty");
        }
        if (null == groupId || groupId.isEmpty()) {
            throw new IllegalArgumentException("groupId cannot be empty");
        }
        if (null == host || host.isEmpty()) {
            throw new IllegalArgumentException("host cannot be empty");
        }
        if (port <=0 ) {
            throw new IllegalArgumentException("port must be a positive integer");
        }
        push = new RedisPush();
        try {
            this.push.open(host, port);
        } catch (Exception e) {
            logger.error("Fail to connect to redis", e);
            throw new RuntimeException("redis connect error", e);
        }
        super.start();
    }

    @Override
    protected void append(E eventObject) {
        // get log message
        if (eventObject instanceof ILoggingEvent) {
            ILoggingEvent event = (ILoggingEvent) eventObject;

            StackTraceElement[] callerData = event.getCallerData();
            String methodName = "unknown";
            String className = "unknown";

            // determine callerData has value
            if (null != callerData && callerData.length > 0) {
                StackTraceElement callerDatum = callerData[0];
                // get method name and class name
                methodName = callerDatum.getMethodName();
                className = callerDatum.getClassName();
            }

            // filter the log
            // check if class name is in groupId, if not return nothing
            if (!className.startsWith(groupId)) {
                return;
            }

            LogMessage logMessage = new LogMessage(systemName, className, methodName,
                    Arrays.asList(event.getFormattedMessage().split(" ")));
            // send message
            try {
                push.send(logMessage);
            } catch (Exception e) {
                logger.error("Fail to send log message to redis", e);
            }
        }
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
