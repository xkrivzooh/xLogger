package xyz.xkrivzooh.xlogger;

import ch.qos.logback.core.util.FileSize;

public final class XLoggerConfigurationBuilder {
    private String identify;

    private String fileName;

    private FileSize maxFileSize;

    private String fileNamePattern;

    private String encodePattern;

    private XLoggerConfigurationBuilder() {
    }

    public static XLoggerConfigurationBuilder builder() {
        return new XLoggerConfigurationBuilder();
    }

    public XLoggerConfigurationBuilder identify(String identify) {
        this.identify = identify;
        return this;
    }

    public XLoggerConfigurationBuilder fileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public XLoggerConfigurationBuilder maxFileSize(FileSize maxFileSize) {
        this.maxFileSize = maxFileSize;
        return this;
    }

    public XLoggerConfigurationBuilder fileNamePattern(String fileNamePattern) {
        this.fileNamePattern = fileNamePattern;
        return this;
    }

    public XLoggerConfigurationBuilder encodePattern(String encodePattern) {
        this.encodePattern = encodePattern;
        return this;
    }

    public XLoggerConfiguration build() {
        XLoggerConfiguration xLoggerConfiguration = new XLoggerConfiguration();
        xLoggerConfiguration.setIdentify(identify);
        xLoggerConfiguration.setFileName(fileName);
        xLoggerConfiguration.setMaxFileSize(maxFileSize);
        xLoggerConfiguration.setFileNamePattern(fileNamePattern);
        xLoggerConfiguration.setEncodePattern(encodePattern);
        return xLoggerConfiguration;
    }
}
