package io.github.ryanrupert.UnixLogger;

import java.io.Serializable;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.log4j.spi.AbstractLogger;
import org.apache.logging.log4j.spi.ExtendedLoggerWrapper;

/**
 * Custom Logger interface with convenience methods for
 * the EMERG, ALERT, CRIT, ERROR, WARNING, NOTICE, INFO and DEBUG custom log levels.
 */
public final class Logger implements Serializable {
    private static final long serialVersionUID = 685727341505000L;
    private final ExtendedLoggerWrapper logger;

    private static final String FQCN = Logger.class.getName();
    private static final Level EMERG = Level.forName("EMERG", 50);
    private static final Level ALERT = Level.forName("ALERT", 100);
    private static final Level CRIT = Level.forName("CRIT", 150);
    private static final Level ERROR = Level.forName("ERROR", 200);
    private static final Level WARNING = Level.forName("WARNING", 250);
    private static final Level NOTICE = Level.forName("NOTICE", 300);
    private static final Level INFO = Level.forName("INFO", 350);
    private static final Level DEBUG = Level.forName("DEBUG", 400);

    private Logger(final org.apache.logging.log4j.Logger logger) {
        this.logger = new ExtendedLoggerWrapper((AbstractLogger) logger, logger.getName(), logger.getMessageFactory());
    }

    /**
     * Returns a custom Logger with the name of the calling class.
     *
     * @return The custom Logger for the calling class.
     */
    public static Logger create() {
        final org.apache.logging.log4j.Logger wrapped = LogManager.getLogger();
        return new Logger(wrapped);
    }

    /**
     * Returns a custom Logger using the fully qualified name of the Class as
     * the Logger name.
     *
     * @param loggerName The Class whose name should be used as the Logger name.
     *            If null it will default to the calling class.
     * @return The custom Logger.
     */
    public static Logger create(final Class<?> loggerName) {
        final org.apache.logging.log4j.Logger wrapped = LogManager.getLogger(loggerName);
        return new Logger(wrapped);
    }

    /**
     * Returns a custom Logger using the fully qualified name of the Class as
     * the Logger name.
     *
     * @param loggerName The Class whose name should be used as the Logger name.
     *            If null it will default to the calling class.
     * @param messageFactory The message factory is used only when creating a
     *            logger, subsequent use does not change the logger but will log
     *            a warning if mismatched.
     * @return The custom Logger.
     */
    public static Logger create(final Class<?> loggerName, final MessageFactory factory) {
        final org.apache.logging.log4j.Logger wrapped = LogManager.getLogger(loggerName, factory);
        return new Logger(wrapped);
    }

    /**
     * Returns a custom Logger using the fully qualified class name of the value
     * as the Logger name.
     *
     * @param value The value whose class name should be used as the Logger
     *            name. If null the name of the calling class will be used as
     *            the logger name.
     * @return The custom Logger.
     */
    public static Logger create(final Object value) {
        final org.apache.logging.log4j.Logger wrapped = LogManager.getLogger(value);
        return new Logger(wrapped);
    }

    /**
     * Returns a custom Logger using the fully qualified class name of the value
     * as the Logger name.
     *
     * @param value The value whose class name should be used as the Logger
     *            name. If null the name of the calling class will be used as
     *            the logger name.
     * @param messageFactory The message factory is used only when creating a
     *            logger, subsequent use does not change the logger but will log
     *            a warning if mismatched.
     * @return The custom Logger.
     */
    public static Logger create(final Object value, final MessageFactory factory) {
        final org.apache.logging.log4j.Logger wrapped = LogManager.getLogger(value, factory);
        return new Logger(wrapped);
    }

    /**
     * Returns a custom Logger with the specified name.
     *
     * @param name The logger name. If null the name of the calling class will
     *            be used.
     * @return The custom Logger.
     */
    public static Logger create(final String name) {
        final org.apache.logging.log4j.Logger wrapped = LogManager.getLogger(name);
        return new Logger(wrapped);
    }

    /**
     * Returns a custom Logger with the specified name.
     *
     * @param name The logger name. If null the name of the calling class will
     *            be used.
     * @param messageFactory The message factory is used only when creating a
     *            logger, subsequent use does not change the logger but will log
     *            a warning if mismatched.
     * @return The custom Logger.
     */
    public static Logger create(final String name, final MessageFactory factory) {
        final org.apache.logging.log4j.Logger wrapped = LogManager.getLogger(name, factory);
        return new Logger(wrapped);
    }

    /**
     * Logs a message with the specific Marker at the {@code EMERG} level.
     *
     * @param marker the marker data specific to this log statement
     * @param msg the message string to be logged
     */
    public void emerg(final Marker marker, final Message msg) {
        logger.logIfEnabled(FQCN, EMERG, marker, msg, (Throwable) null);
    }

    /**
     * Logs a message with the specific Marker at the {@code EMERG} level.
     *
     * @param marker the marker data specific to this log statement
     * @param msg the message string to be logged
     * @param t A Throwable or null.
     */
    public void emerg(final Marker marker, final Message msg, final Throwable t) {
        logger.logIfEnabled(FQCN, EMERG, marker, msg, t);
    }

    /**
     * Logs a message object with the {@code EMERG} level.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message object to log.
     */
    public void emerg(final Marker marker, final Object message) {
        logger.logIfEnabled(FQCN, EMERG, marker, message, (Throwable) null);
    }

    /**
     * Logs a message at the {@code EMERG} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void emerg(final Marker marker, final Object message, final Throwable t) {
        logger.logIfEnabled(FQCN, EMERG, marker, message, t);
    }

    /**
     * Logs a message object with the {@code EMERG} level.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message object to log.
     */
    public void emerg(final Marker marker, final String message) {
        logger.logIfEnabled(FQCN, EMERG, marker, message, (Throwable) null);
    }

    /**
     * Logs a message with parameters at the {@code EMERG} level.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message to log; the format depends on the message factory.
     * @param params parameters to the message.
     * @see #getMessageFactory()
     */
    public void emerg(final Marker marker, final String message, final Object... params) {
        logger.logIfEnabled(FQCN, EMERG, marker, message, params);
    }

    /**
     * Logs a message at the {@code EMERG} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void emerg(final Marker marker, final String message, final Throwable t) {
        logger.logIfEnabled(FQCN, EMERG, marker, message, t);
    }

    /**
     * Logs the specified Message at the {@code EMERG} level.
     *
     * @param msg the message string to be logged
     */
    public void emerg(final Message msg) {
        logger.logIfEnabled(FQCN, EMERG, null, msg, (Throwable) null);
    }

    /**
     * Logs the specified Message at the {@code EMERG} level.
     *
     * @param msg the message string to be logged
     * @param t A Throwable or null.
     */
    public void emerg(final Message msg, final Throwable t) {
        logger.logIfEnabled(FQCN, EMERG, null, msg, t);
    }

    /**
     * Logs a message object with the {@code EMERG} level.
     *
     * @param message the message object to log.
     */
    public void emerg(final Object message) {
        logger.logIfEnabled(FQCN, EMERG, null, message, (Throwable) null);
    }

    /**
     * Logs a message at the {@code EMERG} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void emerg(final Object message, final Throwable t) {
        logger.logIfEnabled(FQCN, EMERG, null, message, t);
    }

    /**
     * Logs a message object with the {@code EMERG} level.
     *
     * @param message the message object to log.
     */
    public void emerg(final String message) {
        logger.logIfEnabled(FQCN, EMERG, null, message, (Throwable) null);
    }

    /**
     * Logs a message with parameters at the {@code EMERG} level.
     *
     * @param message the message to log; the format depends on the message factory.
     * @param params parameters to the message.
     * @see #getMessageFactory()
     */
    public void emerg(final String message, final Object... params) {
        logger.logIfEnabled(FQCN, EMERG, null, message, params);
    }

    /**
     * Logs a message at the {@code EMERG} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void emerg(final String message, final Throwable t) {
        logger.logIfEnabled(FQCN, EMERG, null, message, t);
    }

    /**
     * Logs a message with the specific Marker at the {@code ALERT} level.
     *
     * @param marker the marker data specific to this log statement
     * @param msg the message string to be logged
     */
    public void alert(final Marker marker, final Message msg) {
        logger.logIfEnabled(FQCN, ALERT, marker, msg, (Throwable) null);
    }

    /**
     * Logs a message with the specific Marker at the {@code ALERT} level.
     *
     * @param marker the marker data specific to this log statement
     * @param msg the message string to be logged
     * @param t A Throwable or null.
     */
    public void alert(final Marker marker, final Message msg, final Throwable t) {
        logger.logIfEnabled(FQCN, ALERT, marker, msg, t);
    }

    /**
     * Logs a message object with the {@code ALERT} level.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message object to log.
     */
    public void alert(final Marker marker, final Object message) {
        logger.logIfEnabled(FQCN, ALERT, marker, message, (Throwable) null);
    }

    /**
     * Logs a message at the {@code ALERT} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void alert(final Marker marker, final Object message, final Throwable t) {
        logger.logIfEnabled(FQCN, ALERT, marker, message, t);
    }

    /**
     * Logs a message object with the {@code ALERT} level.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message object to log.
     */
    public void alert(final Marker marker, final String message) {
        logger.logIfEnabled(FQCN, ALERT, marker, message, (Throwable) null);
    }

    /**
     * Logs a message with parameters at the {@code ALERT} level.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message to log; the format depends on the message factory.
     * @param params parameters to the message.
     * @see #getMessageFactory()
     */
    public void alert(final Marker marker, final String message, final Object... params) {
        logger.logIfEnabled(FQCN, ALERT, marker, message, params);
    }

    /**
     * Logs a message at the {@code ALERT} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void alert(final Marker marker, final String message, final Throwable t) {
        logger.logIfEnabled(FQCN, ALERT, marker, message, t);
    }

    /**
     * Logs the specified Message at the {@code ALERT} level.
     *
     * @param msg the message string to be logged
     */
    public void alert(final Message msg) {
        logger.logIfEnabled(FQCN, ALERT, null, msg, (Throwable) null);
    }

    /**
     * Logs the specified Message at the {@code ALERT} level.
     *
     * @param msg the message string to be logged
     * @param t A Throwable or null.
     */
    public void alert(final Message msg, final Throwable t) {
        logger.logIfEnabled(FQCN, ALERT, null, msg, t);
    }

    /**
     * Logs a message object with the {@code ALERT} level.
     *
     * @param message the message object to log.
     */
    public void alert(final Object message) {
        logger.logIfEnabled(FQCN, ALERT, null, message, (Throwable) null);
    }

    /**
     * Logs a message at the {@code ALERT} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void alert(final Object message, final Throwable t) {
        logger.logIfEnabled(FQCN, ALERT, null, message, t);
    }

    /**
     * Logs a message object with the {@code ALERT} level.
     *
     * @param message the message object to log.
     */
    public void alert(final String message) {
        logger.logIfEnabled(FQCN, ALERT, null, message, (Throwable) null);
    }

    /**
     * Logs a message with parameters at the {@code ALERT} level.
     *
     * @param message the message to log; the format depends on the message factory.
     * @param params parameters to the message.
     * @see #getMessageFactory()
     */
    public void alert(final String message, final Object... params) {
        logger.logIfEnabled(FQCN, ALERT, null, message, params);
    }

    /**
     * Logs a message at the {@code ALERT} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void alert(final String message, final Throwable t) {
        logger.logIfEnabled(FQCN, ALERT, null, message, t);
    }

    /**
     * Logs a message with the specific Marker at the {@code CRIT} level.
     *
     * @param marker the marker data specific to this log statement
     * @param msg the message string to be logged
     */
    public void crit(final Marker marker, final Message msg) {
        logger.logIfEnabled(FQCN, CRIT, marker, msg, (Throwable) null);
    }

    /**
     * Logs a message with the specific Marker at the {@code CRIT} level.
     *
     * @param marker the marker data specific to this log statement
     * @param msg the message string to be logged
     * @param t A Throwable or null.
     */
    public void crit(final Marker marker, final Message msg, final Throwable t) {
        logger.logIfEnabled(FQCN, CRIT, marker, msg, t);
    }

    /**
     * Logs a message object with the {@code CRIT} level.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message object to log.
     */
    public void crit(final Marker marker, final Object message) {
        logger.logIfEnabled(FQCN, CRIT, marker, message, (Throwable) null);
    }

    /**
     * Logs a message at the {@code CRIT} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void crit(final Marker marker, final Object message, final Throwable t) {
        logger.logIfEnabled(FQCN, CRIT, marker, message, t);
    }

    /**
     * Logs a message object with the {@code CRIT} level.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message object to log.
     */
    public void crit(final Marker marker, final String message) {
        logger.logIfEnabled(FQCN, CRIT, marker, message, (Throwable) null);
    }

    /**
     * Logs a message with parameters at the {@code CRIT} level.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message to log; the format depends on the message factory.
     * @param params parameters to the message.
     * @see #getMessageFactory()
     */
    public void crit(final Marker marker, final String message, final Object... params) {
        logger.logIfEnabled(FQCN, CRIT, marker, message, params);
    }

    /**
     * Logs a message at the {@code CRIT} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void crit(final Marker marker, final String message, final Throwable t) {
        logger.logIfEnabled(FQCN, CRIT, marker, message, t);
    }

    /**
     * Logs the specified Message at the {@code CRIT} level.
     *
     * @param msg the message string to be logged
     */
    public void crit(final Message msg) {
        logger.logIfEnabled(FQCN, CRIT, null, msg, (Throwable) null);
    }

    /**
     * Logs the specified Message at the {@code CRIT} level.
     *
     * @param msg the message string to be logged
     * @param t A Throwable or null.
     */
    public void crit(final Message msg, final Throwable t) {
        logger.logIfEnabled(FQCN, CRIT, null, msg, t);
    }

    /**
     * Logs a message object with the {@code CRIT} level.
     *
     * @param message the message object to log.
     */
    public void crit(final Object message) {
        logger.logIfEnabled(FQCN, CRIT, null, message, (Throwable) null);
    }

    /**
     * Logs a message at the {@code CRIT} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void crit(final Object message, final Throwable t) {
        logger.logIfEnabled(FQCN, CRIT, null, message, t);
    }

    /**
     * Logs a message object with the {@code CRIT} level.
     *
     * @param message the message object to log.
     */
    public void crit(final String message) {
        logger.logIfEnabled(FQCN, CRIT, null, message, (Throwable) null);
    }

    /**
     * Logs a message with parameters at the {@code CRIT} level.
     *
     * @param message the message to log; the format depends on the message factory.
     * @param params parameters to the message.
     * @see #getMessageFactory()
     */
    public void crit(final String message, final Object... params) {
        logger.logIfEnabled(FQCN, CRIT, null, message, params);
    }

    /**
     * Logs a message at the {@code CRIT} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void crit(final String message, final Throwable t) {
        logger.logIfEnabled(FQCN, CRIT, null, message, t);
    }

    /**
     * Logs a message with the specific Marker at the {@code ERROR} level.
     *
     * @param marker the marker data specific to this log statement
     * @param msg the message string to be logged
     */
    public void error(final Marker marker, final Message msg) {
        logger.logIfEnabled(FQCN, ERROR, marker, msg, (Throwable) null);
    }

    /**
     * Logs a message with the specific Marker at the {@code ERROR} level.
     *
     * @param marker the marker data specific to this log statement
     * @param msg the message string to be logged
     * @param t A Throwable or null.
     */
    public void error(final Marker marker, final Message msg, final Throwable t) {
        logger.logIfEnabled(FQCN, ERROR, marker, msg, t);
    }

    /**
     * Logs a message object with the {@code ERROR} level.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message object to log.
     */
    public void error(final Marker marker, final Object message) {
        logger.logIfEnabled(FQCN, ERROR, marker, message, (Throwable) null);
    }

    /**
     * Logs a message at the {@code ERROR} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void error(final Marker marker, final Object message, final Throwable t) {
        logger.logIfEnabled(FQCN, ERROR, marker, message, t);
    }

    /**
     * Logs a message object with the {@code ERROR} level.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message object to log.
     */
    public void error(final Marker marker, final String message) {
        logger.logIfEnabled(FQCN, ERROR, marker, message, (Throwable) null);
    }

    /**
     * Logs a message with parameters at the {@code ERROR} level.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message to log; the format depends on the message factory.
     * @param params parameters to the message.
     * @see #getMessageFactory()
     */
    public void error(final Marker marker, final String message, final Object... params) {
        logger.logIfEnabled(FQCN, ERROR, marker, message, params);
    }

    /**
     * Logs a message at the {@code ERROR} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void error(final Marker marker, final String message, final Throwable t) {
        logger.logIfEnabled(FQCN, ERROR, marker, message, t);
    }

    /**
     * Logs the specified Message at the {@code ERROR} level.
     *
     * @param msg the message string to be logged
     */
    public void error(final Message msg) {
        logger.logIfEnabled(FQCN, ERROR, null, msg, (Throwable) null);
    }

    /**
     * Logs the specified Message at the {@code ERROR} level.
     *
     * @param msg the message string to be logged
     * @param t A Throwable or null.
     */
    public void error(final Message msg, final Throwable t) {
        logger.logIfEnabled(FQCN, ERROR, null, msg, t);
    }

    /**
     * Logs a message object with the {@code ERROR} level.
     *
     * @param message the message object to log.
     */
    public void error(final Object message) {
        logger.logIfEnabled(FQCN, ERROR, null, message, (Throwable) null);
    }

    /**
     * Logs a message at the {@code ERROR} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void error(final Object message, final Throwable t) {
        logger.logIfEnabled(FQCN, ERROR, null, message, t);
    }

    /**
     * Logs a message object with the {@code ERROR} level.
     *
     * @param message the message object to log.
     */
    public void error(final String message) {
        logger.logIfEnabled(FQCN, ERROR, null, message, (Throwable) null);
    }

    /**
     * Logs a message with parameters at the {@code ERROR} level.
     *
     * @param message the message to log; the format depends on the message factory.
     * @param params parameters to the message.
     * @see #getMessageFactory()
     */
    public void error(final String message, final Object... params) {
        logger.logIfEnabled(FQCN, ERROR, null, message, params);
    }

    /**
     * Logs a message at the {@code ERROR} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void error(final String message, final Throwable t) {
        logger.logIfEnabled(FQCN, ERROR, null, message, t);
    }

    /**
     * Logs a message with the specific Marker at the {@code WARNING} level.
     *
     * @param marker the marker data specific to this log statement
     * @param msg the message string to be logged
     */
    public void warning(final Marker marker, final Message msg) {
        logger.logIfEnabled(FQCN, WARNING, marker, msg, (Throwable) null);
    }

    /**
     * Logs a message with the specific Marker at the {@code WARNING} level.
     *
     * @param marker the marker data specific to this log statement
     * @param msg the message string to be logged
     * @param t A Throwable or null.
     */
    public void warning(final Marker marker, final Message msg, final Throwable t) {
        logger.logIfEnabled(FQCN, WARNING, marker, msg, t);
    }

    /**
     * Logs a message object with the {@code WARNING} level.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message object to log.
     */
    public void warning(final Marker marker, final Object message) {
        logger.logIfEnabled(FQCN, WARNING, marker, message, (Throwable) null);
    }

    /**
     * Logs a message at the {@code WARNING} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void warning(final Marker marker, final Object message, final Throwable t) {
        logger.logIfEnabled(FQCN, WARNING, marker, message, t);
    }

    /**
     * Logs a message object with the {@code WARNING} level.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message object to log.
     */
    public void warning(final Marker marker, final String message) {
        logger.logIfEnabled(FQCN, WARNING, marker, message, (Throwable) null);
    }

    /**
     * Logs a message with parameters at the {@code WARNING} level.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message to log; the format depends on the message factory.
     * @param params parameters to the message.
     * @see #getMessageFactory()
     */
    public void warning(final Marker marker, final String message, final Object... params) {
        logger.logIfEnabled(FQCN, WARNING, marker, message, params);
    }

    /**
     * Logs a message at the {@code WARNING} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void warning(final Marker marker, final String message, final Throwable t) {
        logger.logIfEnabled(FQCN, WARNING, marker, message, t);
    }

    /**
     * Logs the specified Message at the {@code WARNING} level.
     *
     * @param msg the message string to be logged
     */
    public void warning(final Message msg) {
        logger.logIfEnabled(FQCN, WARNING, null, msg, (Throwable) null);
    }

    /**
     * Logs the specified Message at the {@code WARNING} level.
     *
     * @param msg the message string to be logged
     * @param t A Throwable or null.
     */
    public void warning(final Message msg, final Throwable t) {
        logger.logIfEnabled(FQCN, WARNING, null, msg, t);
    }

    /**
     * Logs a message object with the {@code WARNING} level.
     *
     * @param message the message object to log.
     */
    public void warning(final Object message) {
        logger.logIfEnabled(FQCN, WARNING, null, message, (Throwable) null);
    }

    /**
     * Logs a message at the {@code WARNING} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void warning(final Object message, final Throwable t) {
        logger.logIfEnabled(FQCN, WARNING, null, message, t);
    }

    /**
     * Logs a message object with the {@code WARNING} level.
     *
     * @param message the message object to log.
     */
    public void warning(final String message) {
        logger.logIfEnabled(FQCN, WARNING, null, message, (Throwable) null);
    }

    /**
     * Logs a message with parameters at the {@code WARNING} level.
     *
     * @param message the message to log; the format depends on the message factory.
     * @param params parameters to the message.
     * @see #getMessageFactory()
     */
    public void warning(final String message, final Object... params) {
        logger.logIfEnabled(FQCN, WARNING, null, message, params);
    }

    /**
     * Logs a message at the {@code WARNING} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void warning(final String message, final Throwable t) {
        logger.logIfEnabled(FQCN, WARNING, null, message, t);
    }

    /**
     * Logs a message with the specific Marker at the {@code NOTICE} level.
     *
     * @param marker the marker data specific to this log statement
     * @param msg the message string to be logged
     */
    public void notice(final Marker marker, final Message msg) {
        logger.logIfEnabled(FQCN, NOTICE, marker, msg, (Throwable) null);
    }

    /**
     * Logs a message with the specific Marker at the {@code NOTICE} level.
     *
     * @param marker the marker data specific to this log statement
     * @param msg the message string to be logged
     * @param t A Throwable or null.
     */
    public void notice(final Marker marker, final Message msg, final Throwable t) {
        logger.logIfEnabled(FQCN, NOTICE, marker, msg, t);
    }

    /**
     * Logs a message object with the {@code NOTICE} level.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message object to log.
     */
    public void notice(final Marker marker, final Object message) {
        logger.logIfEnabled(FQCN, NOTICE, marker, message, (Throwable) null);
    }

    /**
     * Logs a message at the {@code NOTICE} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void notice(final Marker marker, final Object message, final Throwable t) {
        logger.logIfEnabled(FQCN, NOTICE, marker, message, t);
    }

    /**
     * Logs a message object with the {@code NOTICE} level.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message object to log.
     */
    public void notice(final Marker marker, final String message) {
        logger.logIfEnabled(FQCN, NOTICE, marker, message, (Throwable) null);
    }

    /**
     * Logs a message with parameters at the {@code NOTICE} level.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message to log; the format depends on the message factory.
     * @param params parameters to the message.
     * @see #getMessageFactory()
     */
    public void notice(final Marker marker, final String message, final Object... params) {
        logger.logIfEnabled(FQCN, NOTICE, marker, message, params);
    }

    /**
     * Logs a message at the {@code NOTICE} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void notice(final Marker marker, final String message, final Throwable t) {
        logger.logIfEnabled(FQCN, NOTICE, marker, message, t);
    }

    /**
     * Logs the specified Message at the {@code NOTICE} level.
     *
     * @param msg the message string to be logged
     */
    public void notice(final Message msg) {
        logger.logIfEnabled(FQCN, NOTICE, null, msg, (Throwable) null);
    }

    /**
     * Logs the specified Message at the {@code NOTICE} level.
     *
     * @param msg the message string to be logged
     * @param t A Throwable or null.
     */
    public void notice(final Message msg, final Throwable t) {
        logger.logIfEnabled(FQCN, NOTICE, null, msg, t);
    }

    /**
     * Logs a message object with the {@code NOTICE} level.
     *
     * @param message the message object to log.
     */
    public void notice(final Object message) {
        logger.logIfEnabled(FQCN, NOTICE, null, message, (Throwable) null);
    }

    /**
     * Logs a message at the {@code NOTICE} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void notice(final Object message, final Throwable t) {
        logger.logIfEnabled(FQCN, NOTICE, null, message, t);
    }

    /**
     * Logs a message object with the {@code NOTICE} level.
     *
     * @param message the message object to log.
     */
    public void notice(final String message) {
        logger.logIfEnabled(FQCN, NOTICE, null, message, (Throwable) null);
    }

    /**
     * Logs a message with parameters at the {@code NOTICE} level.
     *
     * @param message the message to log; the format depends on the message factory.
     * @param params parameters to the message.
     * @see #getMessageFactory()
     */
    public void notice(final String message, final Object... params) {
        logger.logIfEnabled(FQCN, NOTICE, null, message, params);
    }

    /**
     * Logs a message at the {@code NOTICE} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void notice(final String message, final Throwable t) {
        logger.logIfEnabled(FQCN, NOTICE, null, message, t);
    }

    /**
     * Logs a message with the specific Marker at the {@code INFO} level.
     *
     * @param marker the marker data specific to this log statement
     * @param msg the message string to be logged
     */
    public void info(final Marker marker, final Message msg) {
        logger.logIfEnabled(FQCN, INFO, marker, msg, (Throwable) null);
    }

    /**
     * Logs a message with the specific Marker at the {@code INFO} level.
     *
     * @param marker the marker data specific to this log statement
     * @param msg the message string to be logged
     * @param t A Throwable or null.
     */
    public void info(final Marker marker, final Message msg, final Throwable t) {
        logger.logIfEnabled(FQCN, INFO, marker, msg, t);
    }

    /**
     * Logs a message object with the {@code INFO} level.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message object to log.
     */
    public void info(final Marker marker, final Object message) {
        logger.logIfEnabled(FQCN, INFO, marker, message, (Throwable) null);
    }

    /**
     * Logs a message at the {@code INFO} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void info(final Marker marker, final Object message, final Throwable t) {
        logger.logIfEnabled(FQCN, INFO, marker, message, t);
    }

    /**
     * Logs a message object with the {@code INFO} level.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message object to log.
     */
    public void info(final Marker marker, final String message) {
        logger.logIfEnabled(FQCN, INFO, marker, message, (Throwable) null);
    }

    /**
     * Logs a message with parameters at the {@code INFO} level.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message to log; the format depends on the message factory.
     * @param params parameters to the message.
     * @see #getMessageFactory()
     */
    public void info(final Marker marker, final String message, final Object... params) {
        logger.logIfEnabled(FQCN, INFO, marker, message, params);
    }

    /**
     * Logs a message at the {@code INFO} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void info(final Marker marker, final String message, final Throwable t) {
        logger.logIfEnabled(FQCN, INFO, marker, message, t);
    }

    /**
     * Logs the specified Message at the {@code INFO} level.
     *
     * @param msg the message string to be logged
     */
    public void info(final Message msg) {
        logger.logIfEnabled(FQCN, INFO, null, msg, (Throwable) null);
    }

    /**
     * Logs the specified Message at the {@code INFO} level.
     *
     * @param msg the message string to be logged
     * @param t A Throwable or null.
     */
    public void info(final Message msg, final Throwable t) {
        logger.logIfEnabled(FQCN, INFO, null, msg, t);
    }

    /**
     * Logs a message object with the {@code INFO} level.
     *
     * @param message the message object to log.
     */
    public void info(final Object message) {
        logger.logIfEnabled(FQCN, INFO, null, message, (Throwable) null);
    }

    /**
     * Logs a message at the {@code INFO} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void info(final Object message, final Throwable t) {
        logger.logIfEnabled(FQCN, INFO, null, message, t);
    }

    /**
     * Logs a message object with the {@code INFO} level.
     *
     * @param message the message object to log.
     */
    public void info(final String message) {
        logger.logIfEnabled(FQCN, INFO, null, message, (Throwable) null);
    }

    /**
     * Logs a message with parameters at the {@code INFO} level.
     *
     * @param message the message to log; the format depends on the message factory.
     * @param params parameters to the message.
     * @see #getMessageFactory()
     */
    public void info(final String message, final Object... params) {
        logger.logIfEnabled(FQCN, INFO, null, message, params);
    }

    /**
     * Logs a message at the {@code INFO} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void info(final String message, final Throwable t) {
        logger.logIfEnabled(FQCN, INFO, null, message, t);
    }

    /**
     * Logs a message with the specific Marker at the {@code DEBUG} level.
     *
     * @param marker the marker data specific to this log statement
     * @param msg the message string to be logged
     */
    public void debug(final Marker marker, final Message msg) {
        logger.logIfEnabled(FQCN, DEBUG, marker, msg, (Throwable) null);
    }

    /**
     * Logs a message with the specific Marker at the {@code DEBUG} level.
     *
     * @param marker the marker data specific to this log statement
     * @param msg the message string to be logged
     * @param t A Throwable or null.
     */
    public void debug(final Marker marker, final Message msg, final Throwable t) {
        logger.logIfEnabled(FQCN, DEBUG, marker, msg, t);
    }

    /**
     * Logs a message object with the {@code DEBUG} level.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message object to log.
     */
    public void debug(final Marker marker, final Object message) {
        logger.logIfEnabled(FQCN, DEBUG, marker, message, (Throwable) null);
    }

    /**
     * Logs a message at the {@code DEBUG} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void debug(final Marker marker, final Object message, final Throwable t) {
        logger.logIfEnabled(FQCN, DEBUG, marker, message, t);
    }

    /**
     * Logs a message object with the {@code DEBUG} level.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message object to log.
     */
    public void debug(final Marker marker, final String message) {
        logger.logIfEnabled(FQCN, DEBUG, marker, message, (Throwable) null);
    }

    /**
     * Logs a message with parameters at the {@code DEBUG} level.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message to log; the format depends on the message factory.
     * @param params parameters to the message.
     * @see #getMessageFactory()
     */
    public void debug(final Marker marker, final String message, final Object... params) {
        logger.logIfEnabled(FQCN, DEBUG, marker, message, params);
    }

    /**
     * Logs a message at the {@code DEBUG} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param marker the marker data specific to this log statement
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void debug(final Marker marker, final String message, final Throwable t) {
        logger.logIfEnabled(FQCN, DEBUG, marker, message, t);
    }

    /**
     * Logs the specified Message at the {@code DEBUG} level.
     *
     * @param msg the message string to be logged
     */
    public void debug(final Message msg) {
        logger.logIfEnabled(FQCN, DEBUG, null, msg, (Throwable) null);
    }

    /**
     * Logs the specified Message at the {@code DEBUG} level.
     *
     * @param msg the message string to be logged
     * @param t A Throwable or null.
     */
    public void debug(final Message msg, final Throwable t) {
        logger.logIfEnabled(FQCN, DEBUG, null, msg, t);
    }

    /**
     * Logs a message object with the {@code DEBUG} level.
     *
     * @param message the message object to log.
     */
    public void debug(final Object message) {
        logger.logIfEnabled(FQCN, DEBUG, null, message, (Throwable) null);
    }

    /**
     * Logs a message at the {@code DEBUG} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void debug(final Object message, final Throwable t) {
        logger.logIfEnabled(FQCN, DEBUG, null, message, t);
    }

    /**
     * Logs a message object with the {@code DEBUG} level.
     *
     * @param message the message object to log.
     */
    public void debug(final String message) {
        logger.logIfEnabled(FQCN, DEBUG, null, message, (Throwable) null);
    }

    /**
     * Logs a message with parameters at the {@code DEBUG} level.
     *
     * @param message the message to log; the format depends on the message factory.
     * @param params parameters to the message.
     * @see #getMessageFactory()
     */
    public void debug(final String message, final Object... params) {
        logger.logIfEnabled(FQCN, DEBUG, null, message, params);
    }

    /**
     * Logs a message at the {@code DEBUG} level including the stack trace of
     * the {@link Throwable} {@code t} passed as parameter.
     *
     * @param message the message to log.
     * @param t the exception to log, including its stack trace.
     */
    public void debug(final String message, final Throwable t) {
        logger.logIfEnabled(FQCN, DEBUG, null, message, t);
    }
}
