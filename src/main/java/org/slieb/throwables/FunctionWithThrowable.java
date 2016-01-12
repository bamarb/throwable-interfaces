package org.slieb.throwables;

/**
 * Generated from java.util.function.Function
 * Extends java.util.function.Function to allow for a checked exception.
 *
 * @param <T> some generic flag
 * @param <R> some generic flag
 * @param <E> The extension
 */
@FunctionalInterface
public interface FunctionWithThrowable<T, R, E extends Throwable> extends java.util.function.Function<T, R> {
    /**
     * Utility method to mark lambdas of type FunctionWithThrowable
     * @param functionwiththrowable The interface instance
     * @param <T> Generic that corresponds to the same generic on Function  
     * @param <R> Generic that corresponds to the same generic on Function  
     * @param <E> The type this interface is allowed to throw
     * @return the cast interface
     */
    static <T, R, E extends Throwable> FunctionWithThrowable<T, R, E> castFunctionWithThrowable(FunctionWithThrowable<T, R, E> functionwiththrowable) {
        return functionwiththrowable;
    }

    /** 
     * Overridden method of FunctionWithThrowable that will call applyWithThrowable, but catching any exceptions.
     *
     * @param v1 parameter to overridden method
     * @return the value
     */
    @Override
    default R apply(T v1) {
        try {
            return applyWithThrowable(v1);
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
    R applyWithThrowable(T v1) throws E;
default java.util.function.Function<T, java.util.Optional<R>> thatReturnsOptional() {
  return (v1) -> {
    try {
      return java.util.Optional.of(applyWithThrowable(v1));
    } catch(Throwable throwable) {
      return java.util.Optional.empty();
    }
  };
}
default java.util.function.Function<T, R> thatReturnsDefaultValue(R defaultReturnValue) {
  return (v1) -> {
    try {
      return applyWithThrowable(v1);
    } catch(Throwable throwable) {
      return defaultReturnValue;
    }
  };
}


    /**
     * 
     */
    default FunctionWithThrowable<T, R, E> withLogging(java.util.logging.Logger logger, java.util.logging.Level level) {
        return (v1) -> {
            try {
                return applyWithThrowable(v1);
            } catch (final Throwable throwable) {
                logger.log(level, "exception in FunctionWithThrowable", throwable);
                throw throwable;
            }
        };
    }


    /**
     * 
     */
    default FunctionWithThrowable<T, R, E> withLogging(java.util.logging.Logger logger) {
  return withLogging(logger, java.util.logging.Level.WARNING);
}

    default FunctionWithThrowable<T, R, E> withLogging() {
  return withLogging(java.util.logging.Logger.getGlobal());
}

}
