package org.slieb.throwables;

/**
 * Generated from java.util.function.BiFunction
 * Extends java.util.function.BiFunction to allow for a checked exception.
 *
 * @param <T> some generic flag
 * @param <U> some generic flag
 * @param <R> some generic flag
 * @param <E> The extension
 */
@FunctionalInterface
public interface BiFunctionWithThrowable<T, U, R, E extends Throwable> extends java.util.function.BiFunction<T, U, R> {
    /**
     * Utility method to mark lambdas of type BiFunctionWithThrowable
     * @param bifunctionwiththrowable The interface instance
     * @param <T> Generic that corresponds to the same generic on BiFunction  
     * @param <U> Generic that corresponds to the same generic on BiFunction  
     * @param <R> Generic that corresponds to the same generic on BiFunction  
     * @param <E> The type this interface is allowed to throw
     * @return the cast interface
     */
    static <T, U, R, E extends Throwable> BiFunctionWithThrowable<T, U, R, E> castBiFunctionWithThrowable(BiFunctionWithThrowable<T, U, R, E> bifunctionwiththrowable) {
        return bifunctionwiththrowable;
    }

    /** 
     * Overridden method of BiFunctionWithThrowable that will call applyWithThrowable, but catching any exceptions.
     *
     * @param v1 parameter to overridden method
     * @param v2 parameter to overridden method
     * @return the value
     */
    @Override
    default R apply(T v1, U v2) {
        try {
            return applyWithThrowable(v1, v2);
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
    R applyWithThrowable(T v1, U v2) throws E;
default java.util.function.BiFunction<T, U, java.util.Optional<R>> thatReturnsOptional() {
  return (v1, v2) -> {
    try {
      return java.util.Optional.of(applyWithThrowable(v1, v2));
    } catch(Throwable throwable) {
      return java.util.Optional.empty();
    }
  };
}
default java.util.function.BiFunction<T, U, R> thatReturnsDefaultValue(R defaultReturnValue) {
  return (v1, v2) -> {
    try {
      return applyWithThrowable(v1, v2);
    } catch(Throwable throwable) {
      return defaultReturnValue;
    }
  };
}


    /**
     * 
     */
    default BiFunctionWithThrowable<T, U, R, E> withLogging(java.util.logging.Logger logger, java.util.logging.Level level) {
        return (v1, v2) -> {
            try {
                return applyWithThrowable(v1, v2);
            } catch (final Throwable throwable) {
                logger.log(level, "exception in BiFunctionWithThrowable", throwable);
                throw throwable;
            }
        };
    }


    /**
     * 
     */
    default BiFunctionWithThrowable<T, U, R, E> withLogging(java.util.logging.Logger logger) {
  return withLogging(logger, java.util.logging.Level.WARNING);
}

    default BiFunctionWithThrowable<T, U, R, E> withLogging() {
  return withLogging(java.util.logging.Logger.getGlobal());
}

}
