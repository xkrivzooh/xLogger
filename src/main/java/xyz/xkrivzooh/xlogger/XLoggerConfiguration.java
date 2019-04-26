package xyz.xkrivzooh.xlogger;

import java.util.Objects;

import ch.qos.logback.core.util.FileSize;

public class XLoggerConfiguration {
    private String identify;

    private String fileName;

    private FileSize maxFileSize;

    private String fileNamePattern;

    private String encodePattern;

    public static XLoggerConfiguration getDefaultConfiguration(String identify) {
        XLoggerConfiguration configuration = XLoggerConfigurationBuilder.builder()
                .identify(identify)
                .fileName(identify + ".log")
                .maxFileSize(FileSize.valueOf("1gb"))
                .fileNamePattern(identify + "-%d{yyyy-MM-dd-HH}.%i.log.gz")
                .encodePattern("%d{yyyy-MM-dd HH:mm:ss.SSS} %magenta([%thread]) %highlight(%-5level) %logger{36}:%L - %msg%n")
                .build();
        return configuration;
    }

    XLoggerConfiguration() {
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public FileSize getMaxFileSize() {
        return maxFileSize;
    }

    public void setMaxFileSize(FileSize maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public String getFileNamePattern() {
        return fileNamePattern;
    }

    public void setFileNamePattern(String fileNamePattern) {
        this.fileNamePattern = fileNamePattern;
    }

    public String getEncodePattern() {
        return encodePattern;
    }

    public void setEncodePattern(String encodePattern) {
        this.encodePattern = encodePattern;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XLoggerConfiguration that = (XLoggerConfiguration) o;
        return Objects.equals(identify, that.identify) &&
                Objects.equals(fileName, that.fileName) &&
                Objects.equals(maxFileSize, that.maxFileSize) &&
                Objects.equals(fileNamePattern, that.fileNamePattern) &&
                Objects.equals(encodePattern, that.encodePattern);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identify, fileName, maxFileSize, fileNamePattern, encodePattern);
    }

    @Override
    public String toString() {
        return "XLoggerConfiguration{" +
                "identify='" + identify + '\'' +
                ", fileName='" + fileName + '\'' +
                ", maxFileSize=" + maxFileSize +
                ", fileNamePattern='" + fileNamePattern + '\'' +
                ", encodePattern='" + encodePattern + '\'' +
                '}';
    }
}
