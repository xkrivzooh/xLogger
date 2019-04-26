package xyz.xkrivzooh.xlogger;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.Appender;
import org.slf4j.Logger;
import org.slf4j.Marker;

public class XLogger implements Logger {

    private final Logger logger;

    private final Appender<ILoggingEvent> appender;

    XLogger(Logger logger, Appender<ILoggingEvent> appender) {
        this.logger = logger;
        this.appender = appender;
    }

    public String getName() {
        return appender.getName();
    }

    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    public void trace(String msg) {
        LoggingEvent loggingEvent = new LoggingEvent(appender.getName(),
                (ch.qos.logback.classic.Logger) logger, Level.TRACE, msg, null, null);
        appender.doAppend(loggingEvent);
    }

    public void trace(String format, Object arg) {
        LoggingEvent loggingEvent = new LoggingEvent(appender.getName(),
                (ch.qos.logback.classic.Logger) logger, Level.TRACE, format, null, new Object[] {arg});
        appender.doAppend(loggingEvent);
    }

    public void trace(String format, Object arg1, Object arg2) {
        LoggingEvent loggingEvent = new LoggingEvent(appender.getName(),
                (ch.qos.logback.classic.Logger) logger, Level.TRACE, format, null, new Object[] {arg1, arg2});
        appender.doAppend(loggingEvent);
    }

    public void trace(String format, Object... arguments) {
        LoggingEvent loggingEvent = new LoggingEvent(appender.getName(),
                (ch.qos.logback.classic.Logger) logger, Level.TRACE, format, null, arguments);
        appender.doAppend(loggingEvent);
    }

    public void trace(String msg, Throwable t) {
        LoggingEvent loggingEvent = new LoggingEvent(appender.getName(),
                (ch.qos.logback.classic.Logger) logger, Level.TRACE, msg, t, null);
        appender.doAppend(loggingEvent);
    }

    public boolean isTraceEnabled(Marker marker) {
        throw new UnsupportedOperationException("public boolean isTraceEnabled(Marker marker)");
    }

    public void trace(Marker marker, String msg) {
        throw new UnsupportedOperationException("public void trace(Marker marker, String msg)");
    }

    public void trace(Marker marker, String format, Object arg) {
        throw new UnsupportedOperationException("public void trace(Marker marker, String format, Object arg)");
    }

    public void trace(Marker marker, String format, Object arg1, Object arg2) {
        throw new UnsupportedOperationException("public void trace(Marker marker, String format, Object arg1, Object arg2)");
    }

    public void trace(Marker marker, String format, Object... argArray) {
        throw new UnsupportedOperationException("public void trace(Marker marker, String format, Object... argArray)");
    }

    public void trace(Marker marker, String msg, Throwable t) {
        throw new UnsupportedOperationException("public void trace(Marker marker, String msg, Throwable t)");
    }

    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    public void debug(String msg) {
        LoggingEvent loggingEvent = new LoggingEvent(appender.getName(),
                (ch.qos.logback.classic.Logger) logger, Level.DEBUG, msg, null, null);
        appender.doAppend(loggingEvent);
    }

    public void debug(String format, Object arg) {
        LoggingEvent loggingEvent = new LoggingEvent(appender.getName(),
                (ch.qos.logback.classic.Logger) logger, Level.DEBUG, format, null, new Object[] {arg});
        appender.doAppend(loggingEvent);
    }

    public void debug(String format, Object arg1, Object arg2) {
        LoggingEvent loggingEvent = new LoggingEvent(appender.getName(),
                (ch.qos.logback.classic.Logger) logger, Level.DEBUG, format, null, new Object[] {arg1, arg2});
        appender.doAppend(loggingEvent);
    }

    public void debug(String format, Object... arguments) {
        LoggingEvent loggingEvent = new LoggingEvent(appender.getName(),
                (ch.qos.logback.classic.Logger) logger, Level.DEBUG, format, null, arguments);
        appender.doAppend(loggingEvent);
    }

    public void debug(String msg, Throwable t) {
        LoggingEvent loggingEvent = new LoggingEvent(appender.getName(),
                (ch.qos.logback.classic.Logger) logger, Level.DEBUG, msg, t, null);
        appender.doAppend(loggingEvent);
    }

    public boolean isDebugEnabled(Marker marker) {
        throw new UnsupportedOperationException("public boolean isDebugEnabled(Marker marker)");
    }

    public void debug(Marker marker, String msg) {
        throw new UnsupportedOperationException("public void debug(Marker marker, String msg)");
    }

    public void debug(Marker marker, String format, Object arg) {
        throw new UnsupportedOperationException("public void debug(Marker marker, String format, Object arg)");
    }

    public void debug(Marker marker, String format, Object arg1, Object arg2) {
        throw new UnsupportedOperationException("public void debug(Marker marker, String format, Object arg1, Object arg2)");
    }

    public void debug(Marker marker, String format, Object... arguments) {
        throw new UnsupportedOperationException("public void debug(Marker marker, String format, Object... arguments)");
    }

    public void debug(Marker marker, String msg, Throwable t) {
        throw new UnsupportedOperationException("public void debug(Marker marker, String msg, Throwable t)");
    }

    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    public void info(String msg) {
        LoggingEvent loggingEvent = new LoggingEvent(appender.getName(),
                (ch.qos.logback.classic.Logger) logger, Level.INFO, msg, null, null);
        appender.doAppend(loggingEvent);
    }

    public void info(String format, Object arg) {
        LoggingEvent loggingEvent = new LoggingEvent(appender.getName(),
                (ch.qos.logback.classic.Logger) logger, Level.INFO, format, null, new Object[] {arg});
        appender.doAppend(loggingEvent);
    }

    public void info(String format, Object arg1, Object arg2) {
        LoggingEvent loggingEvent = new LoggingEvent(appender.getName(),
                (ch.qos.logback.classic.Logger) logger, Level.INFO, format, null, new Object[] {arg1, arg2});
        appender.doAppend(loggingEvent);
    }

    public void info(String format, Object... arguments) {
        LoggingEvent loggingEvent = new LoggingEvent(appender.getName(),
                (ch.qos.logback.classic.Logger) logger, Level.INFO, format, null, arguments);
        appender.doAppend(loggingEvent);
    }

    public void info(String msg, Throwable t) {
        LoggingEvent loggingEvent = new LoggingEvent(appender.getName(),
                (ch.qos.logback.classic.Logger) logger, Level.INFO, msg, t, null);
        appender.doAppend(loggingEvent);
    }

    public boolean isInfoEnabled(Marker marker) {
        throw new UnsupportedOperationException("public boolean isInfoEnabled(Marker marker)");
    }

    public void info(Marker marker, String msg) {
        throw new UnsupportedOperationException("public void info(Marker marker, String msg)");
    }

    public void info(Marker marker, String format, Object arg) {
        throw new UnsupportedOperationException("public void info(Marker marker, String format, Object arg)");
    }

    public void info(Marker marker, String format, Object arg1, Object arg2) {
        throw new UnsupportedOperationException("public void info(Marker marker, String format, Object arg1, Object arg2)");
    }

    public void info(Marker marker, String format, Object... arguments) {
        throw new UnsupportedOperationException("public void info(Marker marker, String format, Object... arguments)");
    }

    public void info(Marker marker, String msg, Throwable t) {
        throw new UnsupportedOperationException("public void info(Marker marker, String msg, Throwable t)");
    }

    public boolean isWarnEnabled() {
        return logger.isWarnEnabled();
    }

    public void warn(String msg) {
        LoggingEvent loggingEvent = new LoggingEvent(appender.getName(),
                (ch.qos.logback.classic.Logger) logger, Level.WARN, msg, null, null);
        appender.doAppend(loggingEvent);
    }

    public void warn(String format, Object arg) {
        LoggingEvent loggingEvent = new LoggingEvent(appender.getName(),
                (ch.qos.logback.classic.Logger) logger, Level.WARN, format, null, new Object[] {arg});
        appender.doAppend(loggingEvent);
    }

    public void warn(String format, Object... arguments) {
        LoggingEvent loggingEvent = new LoggingEvent(appender.getName(),
                (ch.qos.logback.classic.Logger) logger, Level.WARN, format, null, arguments);
        appender.doAppend(loggingEvent);
    }

    public void warn(String format, Object arg1, Object arg2) {
        LoggingEvent loggingEvent = new LoggingEvent(appender.getName(),
                (ch.qos.logback.classic.Logger) logger, Level.WARN, format, null, new Object[] {arg1, arg2});
        appender.doAppend(loggingEvent);
    }

    public void warn(String msg, Throwable t) {
        LoggingEvent loggingEvent = new LoggingEvent(appender.getName(),
                (ch.qos.logback.classic.Logger) logger, Level.WARN, msg, t, null);
        appender.doAppend(loggingEvent);
    }

    public boolean isWarnEnabled(Marker marker) {
        throw new UnsupportedOperationException("public boolean isWarnEnabled(Marker marker)");
    }

    public void warn(Marker marker, String msg) {
        throw new UnsupportedOperationException("public void warn(Marker marker, String msg)");
    }

    public void warn(Marker marker, String format, Object arg) {
        throw new UnsupportedOperationException("public void warn(Marker marker, String format, Object arg)");
    }

    public void warn(Marker marker, String format, Object arg1, Object arg2) {
        throw new UnsupportedOperationException("public void warn(Marker marker, String format, Object arg1, Object arg2)");
    }

    public void warn(Marker marker, String format, Object... arguments) {
        throw new UnsupportedOperationException("public void warn(Marker marker, String format, Object... arguments)");
    }

    public void warn(Marker marker, String msg, Throwable t) {
        throw new UnsupportedOperationException("public void warn(Marker marker, String msg, Throwable t)");
    }

    public boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }

    public void error(String msg) {
        LoggingEvent loggingEvent = new LoggingEvent(appender.getName(),
                (ch.qos.logback.classic.Logger) logger, Level.ERROR, msg, null, null);
        appender.doAppend(loggingEvent);
    }

    public void error(String format, Object arg) {
        LoggingEvent loggingEvent = new LoggingEvent(appender.getName(),
                (ch.qos.logback.classic.Logger) logger, Level.ERROR, format, null, new Object[] {arg});
        appender.doAppend(loggingEvent);
    }

    public void error(String format, Object arg1, Object arg2) {
        LoggingEvent loggingEvent = new LoggingEvent(appender.getName(),
                (ch.qos.logback.classic.Logger) logger, Level.ERROR, format, null, new Object[] {arg1, arg2});
        appender.doAppend(loggingEvent);
    }

    public void error(String format, Object... arguments) {
        LoggingEvent loggingEvent = new LoggingEvent(appender.getName(),
                (ch.qos.logback.classic.Logger) logger, Level.ERROR, format, null, arguments);
        appender.doAppend(loggingEvent);
    }

    public void error(String msg, Throwable t) {
        LoggingEvent loggingEvent = new LoggingEvent(appender.getName(),
                (ch.qos.logback.classic.Logger) logger, Level.ERROR, msg, t, null);
        appender.doAppend(loggingEvent);
    }

    public boolean isErrorEnabled(Marker marker) {
        throw new UnsupportedOperationException("public boolean isErrorEnabled(Marker marker)");
    }

    public void error(Marker marker, String msg) {
        throw new UnsupportedOperationException("public void error(Marker marker, String msg)");
    }

    public void error(Marker marker, String format, Object arg) {
        throw new UnsupportedOperationException("public void error(Marker marker, String format, Object arg)");
    }

    public void error(Marker marker, String format, Object arg1, Object arg2) {
        throw new UnsupportedOperationException("public void error(Marker marker, String format, Object arg1, Object arg2)");
    }

    public void error(Marker marker, String format, Object... arguments) {
        throw new UnsupportedOperationException("public void error(Marker marker, String format, Object... arguments)");
    }

    public void error(Marker marker, String msg, Throwable t) {
        throw new UnsupportedOperationException("public void error(Marker marker, String msg, Throwable t)");
    }
}
