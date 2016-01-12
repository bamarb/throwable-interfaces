package org.slieb.throwables;

/**
 * Generated from java.util.function.DoubleToLongFunction
 * Extends java.util.function.DoubleToLongFunction to allow for a checked exception.
 *
 * @param <E> The extension
 */
@FunctionalInterface
public interface DoubleToLongFunctionWithThrowable<E extends Throwable> extends java.util.function.DoubleToLongFunction {
    /**
     * Utility method to mark lambdas of type DoubleToLongFunctionWithThrowable
     * @param doubletolongfunctionwiththrowable The interface instance
     * @param <E> The type this interface is allowed to throw
     * @return the cast interface
     */
    static <E extends Throwable> DoubleToLongFunctionWithThrowable<E> castDoubleToLongFunctionWithThrowable(DoubleToLongFunctionWithThrowable<E> doubletolongfunctionwiththrowable) {
        return doubletolongfunctionwiththrowable;
    }
    /**
     * Utility method to convert DoubleToLongFunctionWithThrowable
     * @param doubletolongfunction The interface instance
     * @param <E> The type this interface is allowed to throw
     * @return the cast interface
     */
    static <E extends Throwable> DoubleToLongFunctionWithThrowable<E> asDoubleToLongFunctionWithThrowable(java.util.function.DoubleToLongFunction doubletolongfunction) {
        return doubletolongfunction::applyAsLong;
    }

    /** 
     * Overridden method of DoubleToLongFunctionWithThrowable that will call applyAsLongWithThrowable, but catching any exceptions.
     *
     * @param v1 parameter to overridden method
     * @return the value
     */
    @Override
    default long applyAsLong(double v1) {
        try {
            return applyAsLongWithThrowable(v1);
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
     * @return the value
     * @throws E some exception
     */
    long applyAsLongWithThrowable(double v1) throws E;


    /**
     * @param logger The logger to log exceptions on
     * @param level The log level to use when logging exceptions
     * @param message A message to use for logging exceptions
     * @return An interface that will log all exceptions to given logger
     */
    @SuppressWarnings("Duplicates")
    default DoubleToLongFunctionWithThrowable<E> withLogging(java.util.logging.Logger logger, java.util.logging.Level level, String message) {
        return (v1) -> {
            try {
                return applyAsLongWithThrowable(v1);
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
    default DoubleToLongFunctionWithThrowable<E> withLogging(java.util.logging.Logger logger) {
        return withLogging(logger, java.util.logging.Level.WARNING, "Exception in DoubleToLongFunctionWithThrowable");
    }


    /**
     * Will log WARNING level exceptions on logger if they occur within the interface
     * @return An interface that will log exceptions on global logger
     */
    default DoubleToLongFunctionWithThrowable<E> withLogging() {
        return withLogging(java.util.logging.Logger.getGlobal());
    }

}
