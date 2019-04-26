# XLogger

## 解决的问题

中间件项目开发过程中经常需要打印日志到一些特定文件中，比如：

*将dubbo provider端的请求记录到`dubbo-access-provider.log`日志文件中，需要支持日志轮转，压缩等功能*




## 使用实例

```java
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
```

