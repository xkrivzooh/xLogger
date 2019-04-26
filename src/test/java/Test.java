import ch.qos.logback.core.util.FileSize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.xkrivzooh.xlogger.XLogger;
import xyz.xkrivzooh.xlogger.XLoggerConfiguration;
import xyz.xkrivzooh.xlogger.XLoggerConfigurationBuilder;
import xyz.xkrivzooh.xlogger.XLoggerFactory;

public class Test {

    private final static Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) throws InterruptedException {
        XLogger xlogger = XLoggerFactory.getLogger("yyyyy");
        xlogger.info("info()");
        xlogger.info("info({})", "hello");
        xlogger.info("logger.isDebugEnabled(): " + logger.isDebugEnabled());
        xlogger.info("logger.isInfoEnabled() " + logger.isInfoEnabled());
        xlogger.info("logger.isTraceEnabled() " + logger.isTraceEnabled());

        logger.info("logback info()");
    }

    public static void test() {
        String identify = "dubbo-access-provider";
        XLoggerConfiguration configuration = XLoggerConfigurationBuilder.builder()
                .identify(identify)
                .fileName(identify + ".log")
                .maxFileSize(FileSize.valueOf("1gb"))
                .fileNamePattern(identify + "-%d{yyyy-MM-dd-HH}.%i.log")
                .encodePattern("%d{yyyy-MM-dd HH:mm:ss.SSS} %magenta([%thread]) %highlight(%-5level) %logger{36}:%L - %msg%n")
                .build();
        XLogger logger = XLoggerFactory.getLogger(configuration);

        logger.info("some log message");
        logger.debug("some log message");
    }
}
