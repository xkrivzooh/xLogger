package xyz.xkrivzooh.xlogger;

import java.util.Objects;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;

public class XLoggerFactory {

    public static XLogger getLogger(String identify) {
        Logger logger = org.slf4j.LoggerFactory.getLogger(identify);
        Appender<ILoggingEvent> appender = APPENDER_CACHE.getUnchecked(XLoggerConfiguration.getDefaultConfiguration(identify));
        return new XLogger(logger, appender);
    }

    public static XLogger getLogger(XLoggerConfiguration configuration) {
        Preconditions.checkNotNull(configuration, "xLoggerConfiguration can not be null");
        String identify = configuration.getIdentify();
        Logger logger = org.slf4j.LoggerFactory.getLogger(identify);
        Appender<ILoggingEvent> appender = APPENDER_CACHE.getUnchecked(configuration);
        return new XLogger(logger, appender);
    }

    private static final LoadingCache<PatternLayoutEncoderCacheKey, PatternLayoutEncoder> PATTERN_LAYOUT_ENCODER_CACHE = CacheBuilder
            .newBuilder().build(new CacheLoader<PatternLayoutEncoderCacheKey, PatternLayoutEncoder>() {
                @Override
                public PatternLayoutEncoder load(PatternLayoutEncoderCacheKey key) throws Exception {
                    PatternLayoutEncoder patternLayoutEncoder = new PatternLayoutEncoder();
                    patternLayoutEncoder.setContext(key.getContext());
                    patternLayoutEncoder.setPattern(key.getPattern());
                    patternLayoutEncoder.start();
                    return patternLayoutEncoder;
                }
            });

    private static final LoadingCache<XLoggerConfiguration, Appender<ILoggingEvent>> APPENDER_CACHE = CacheBuilder
            .newBuilder().build(new CacheLoader<XLoggerConfiguration, Appender<ILoggingEvent>>() {
                @Override
                public Appender<ILoggingEvent> load(XLoggerConfiguration key) throws Exception {
                    return getAppender(key);
                }
            });

    private static Appender<ILoggingEvent> getAppender(XLoggerConfiguration configuration) {
        LoggerContext loggerContext = (LoggerContext) org.slf4j.LoggerFactory.getILoggerFactory();

        PatternLayoutEncoderCacheKey patternLayoutEncoderCacheKey =
                new PatternLayoutEncoderCacheKey(configuration.getEncodePattern(), loggerContext);
        PatternLayoutEncoder patternLayoutEncoder = PATTERN_LAYOUT_ENCODER_CACHE.getUnchecked(patternLayoutEncoderCacheKey);

        RollingFileAppender<ILoggingEvent> rollingFileAppender = new RollingFileAppender<ILoggingEvent>();
        SizeAndTimeBasedRollingPolicy<ILoggingEvent> rollingPolicy = new SizeAndTimeBasedRollingPolicy<ILoggingEvent>();
        rollingFileAppender.setContext(loggerContext);
        rollingFileAppender.setAppend(true);
        rollingFileAppender.setFile(configuration.getFileName());
        rollingFileAppender.setRollingPolicy(rollingPolicy);
        rollingFileAppender.setTriggeringPolicy(rollingPolicy);
        rollingFileAppender.setEncoder(patternLayoutEncoder);
        rollingFileAppender.setName(configuration.getIdentify());

        rollingPolicy.setContext(loggerContext);
        rollingPolicy.setParent(rollingFileAppender);
        rollingPolicy.setMaxFileSize(configuration.getMaxFileSize());
        rollingPolicy.setFileNamePattern(configuration.getFileNamePattern());
        rollingPolicy.start();

        rollingFileAppender.start();

        return rollingFileAppender;
    }

    static class PatternLayoutEncoderCacheKey {
        private final String pattern;

        private final LoggerContext context;

        public PatternLayoutEncoderCacheKey(String pattern, LoggerContext context) {
            this.pattern = pattern;
            this.context = context;
        }

        public String getPattern() {
            return pattern;
        }

        public LoggerContext getContext() {
            return context;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PatternLayoutEncoderCacheKey that = (PatternLayoutEncoderCacheKey) o;
            return Objects.equals(pattern, that.pattern) &&
                    Objects.equals(context, that.context);
        }

        @Override
        public int hashCode() {
            return Objects.hash(pattern, context);
        }
    }

}
