package com.sample.core.logging;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public final class SystemLogger {
    private static final String DEFAULT_LOG4J_CONFIGURATION_FILE_PATH = "log4j.properties";
    private static final String LOG_MESSAGE_EXCEPTION_PREFIX = "Exception: ";
    private static boolean initialized;

    
    private SystemLogger(Class<?> categoryClass) {
    }

    
    public static Logger getLogger(Class<?> categoryClass) {
        if (!initialized) {
            PropertyConfigurator.configureAndWatch(DEFAULT_LOG4J_CONFIGURATION_FILE_PATH);
            initialized = true;
        }

        return Logger.getLogger(categoryClass);
    }
    
    public static void error(Class<?> categoryClass, Object message) {
        getLogger(categoryClass).error(message);
    }

    
    public static void error(Class<?> categoryClass, Throwable throwable) {
        error(categoryClass, LOG_MESSAGE_EXCEPTION_PREFIX, throwable);
    }

    
    public static void error(Class<?> categoryClass, Object message, Throwable throwable) {
        getLogger(categoryClass).error(message, throwable);
    }

    
    public static boolean isErrorEnabled(Class<?> categoryClass) {
        return getLogger(categoryClass).isEnabledFor(Level.ERROR);
    }

    public static void info(Class<?> categoryClass, Object message) {
        getLogger(categoryClass).info(message);
    }


    public static void info(Class<?> categoryClass, Throwable throwable) {
        info(categoryClass, LOG_MESSAGE_EXCEPTION_PREFIX, throwable);
    }


    public static void info(Class<?> categoryClass, Object message, Throwable throwable) {
        getLogger(categoryClass).info(message, throwable);
    }


    public static boolean isInfoEnabled(Class<?> categoryClass) {
        return getLogger(categoryClass).isEnabledFor(Level.INFO);
    }

    public static void debug(Class<?> categoryClass, Object message) {
        getLogger(categoryClass).debug(message);
    }


    public static void debug(Class<?> categoryClass, Throwable throwable) {
        debug(categoryClass, LOG_MESSAGE_EXCEPTION_PREFIX, throwable);
    }

    public static void debug(Class<?> categoryClass, Object message, Throwable throwable) {
        getLogger(categoryClass).debug(message, throwable);
    }

    public static boolean isDebugEnabled(Class<?> categoryClass) {
        return getLogger(categoryClass).isEnabledFor(Level.DEBUG);
    }
}
