package org.slieb.throwables;

/**
 * Generated from java.util.function.IntConsumer
 * Extends java.util.function.IntConsumer to allow for a checked exception.
 *
 * @param <E> The extension
 */
@FunctionalInterface
public interface IntConsumerWithThrowable<E extends Throwable> extends java.util.function.IntConsumer {
    /**
     * Utility method to mark lambdas of type IntConsumerWithThrowable
     * @param intconsumerwiththrowable The interface instance
     * @param <E> The type this interface is allowed to throw
     * @return the cast interface
     */
    static <E extends Throwable> IntConsumerWithThrowable<E> castIntConsumerWithThrowable(IntConsumerWithThrowable<E> intconsumerwiththrowable) {
        return intconsumerwiththrowable;
    }

    /** 
     * Overridden method of IntConsumerWithThrowable that will call acceptWithThrowable, but catching any exceptions.
     *
     * @param v1 parameter to overridden method
     */
    @Override
    default void accept(int v1) {
        try {
            acceptWithThrowable(v1);
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
     * @throws E some exception
     */
    void acceptWithThrowable(int v1) throws E;
default java.util.function.IntConsumer thatDoesNothing() {
   return (v1) -> {
    try {
      acceptWithThrowable(v1);
    } catch(Throwable ignored) {}
  };
}


    /**
     * 
     */
    default IntConsumerWithThrowable<E> withLogging(java.util.logging.Logger logger, java.util.logging.Level level) {
        return (v1) -> {
            try {
                acceptWithThrowable(v1);
            } catch (final Throwable throwable) {
                logger.log(level, "exception in IntConsumerWithThrowable", throwable);
                throw throwable;
            }
        };
    }


    /**
     * 
     */
    default IntConsumerWithThrowable<E> withLogging(java.util.logging.Logger logger) {
  return withLogging(logger, java.util.logging.Level.WARNING);
}

    default IntConsumerWithThrowable<E> withLogging() {
  return withLogging(java.util.logging.Logger.getGlobal());
}

}
