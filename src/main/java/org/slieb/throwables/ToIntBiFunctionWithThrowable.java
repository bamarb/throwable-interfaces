package org.slieb.throwables;

/**
 * Generated from java.util.function.ToIntBiFunction
 * Extends java.util.function.ToIntBiFunction to allow for a checked exception.
 *
 * @param <T> some generic flag
 * @param <U> some generic flag
 * @param <E> The extension
 */
@FunctionalInterface
public interface ToIntBiFunctionWithThrowable<T, U, E extends Throwable> extends java.util.function.ToIntBiFunction<T, U> {
    /**
     * Utility method to mark lambdas of type ToIntBiFunctionWithThrowable
     * @param tointbifunctionwiththrowable The interface instance
     * @param <T> Generic that corresponds to the same generic on ToIntBiFunction  
     * @param <U> Generic that corresponds to the same generic on ToIntBiFunction  
     * @param <E> The type this interface is allowed to throw
     * @return the cast interface
     */
    static <T, U, E extends Throwable> ToIntBiFunctionWithThrowable<T, U, E> castToIntBiFunctionWithThrowable(ToIntBiFunctionWithThrowable<T, U, E> tointbifunctionwiththrowable) {
        return tointbifunctionwiththrowable;
    }
    /**
     * Utility method to convert ToIntBiFunctionWithThrowable
     * @param tointbifunction The interface instance
     * @param <T> Generic that corresponds to the same generic on ToIntBiFunction  
     * @param <U> Generic that corresponds to the same generic on ToIntBiFunction  
     * @param <E> The type this interface is allowed to throw
     * @return the cast interface
     */
    static <T, U, E extends Throwable> ToIntBiFunctionWithThrowable<T, U, E> asToIntBiFunctionWithThrowable(java.util.function.ToIntBiFunction<T, U> tointbifunction) {
        return tointbifunction::applyAsInt;
    }

    /** 
     * Overridden method of ToIntBiFunctionWithThrowable that will call applyAsIntWithThrowable, but catching any exceptions.
     *
     * @param v1 parameter to overridden method
     * @param v2 parameter to overridden method
     * @return the value
     */
    @Override
    default int applyAsInt(T v1, U v2) {
        try {
            return applyAsIntWithThrowable(v1, v2);
        } catch (final RuntimeException | Error exception) {
            throw exception;
        } catch (final Throwable throwable) {
            throw new org.slieb.throwables.SuppressedException(throwable);
        }
    }

    /** 
     * Functional method that will throw exceptions.
     *
     * @param v1 parameter to overridden method
     * @param v2 parameter to overridden method
     * @return the value
     * @throws E some exception
     */
    int applyAsIntWithThrowable(T v1, U v2) throws E;


    /**
     * @param logger The logger to log exceptions on
     * @param level The log level to use when logging exceptions
     * @param message A message to use for logging exceptions
     * @return An interface that will log all exceptions to given logger
     */
    @SuppressWarnings("Duplicates")
    default ToIntBiFunctionWithThrowable<T, U, E> withLogging(java.util.logging.Logger logger, java.util.logging.Level level, String message) {
        return (v1, v2) -> {
            try {
                return applyAsIntWithThrowable(v1, v2);
            } catch (final Throwable throwable) {
                logger.log(level, message, throwable);
                throw throwable;
            }
        };
    }


    /**
     * Will log WARNING level exceptions on logger if they occur within the interface
     * @param logger The logger instance to log exceptions on
     * @return An interface that will log exceptions on given logger
     */
    default ToIntBiFunctionWithThrowable<T, U, E> withLogging(java.util.logging.Logger logger) {
        return withLogging(logger, java.util.logging.Level.WARNING, "Exception in ToIntBiFunctionWithThrowable");
    }


    /**
     * Will log WARNING level exceptions on logger if they occur within the interface
     * @return An interface that will log exceptions on global logger
     */
    default ToIntBiFunctionWithThrowable<T, U, E> withLogging() {
        return withLogging(java.util.logging.Logger.getGlobal());
    }

}
