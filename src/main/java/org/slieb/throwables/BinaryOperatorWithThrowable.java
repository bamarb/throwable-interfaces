package org.slieb.throwables;

/**
 * Generated from java.util.function.BinaryOperator
 * Extends java.util.function.BinaryOperator to allow for a checked exception.
 *
 * @param <T> some generic flag
 * @param <E> The extension
 */
@FunctionalInterface
public interface BinaryOperatorWithThrowable<T, E extends Throwable> extends java.util.function.BinaryOperator<T> {
    /**
     * Utility method to mark lambdas of type BinaryOperatorWithThrowable
     * @param binaryoperatorwiththrowable The interface instance
     * @param <T> Generic that corresponds to the same generic on BinaryOperator  
     * @param <E> The type this interface is allowed to throw
     * @return the cast interface
     */
    static <T, E extends Throwable> BinaryOperatorWithThrowable<T, E> castBinaryOperatorWithThrowable(BinaryOperatorWithThrowable<T, E> binaryoperatorwiththrowable) {
        return binaryoperatorwiththrowable;
    }

    /** 
     * Overridden method of BinaryOperatorWithThrowable that will call applyWithThrowable, but catching any exceptions.
     *
     * @param v1 parameter to overridden method
     * @param v2 parameter to overridden method
     * @return the value
     */
    @Override
    default T apply(T v1, T v2) {
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
    T applyWithThrowable(T v1, T v2) throws E;
default java.util.function.BinaryOperator<T> thatReturnsDefaultValue(T defaultReturnValue) {
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
    default BinaryOperatorWithThrowable<T, E> withLogging(java.util.logging.Logger logger, java.util.logging.Level level) {
        return (v1, v2) -> {
            try {
                return applyWithThrowable(v1, v2);
            } catch (final Throwable throwable) {
                logger.log(level, "exception in BinaryOperatorWithThrowable", throwable);
                throw throwable;
            }
        };
    }


    /**
     * 
     */
    default BinaryOperatorWithThrowable<T, E> withLogging(java.util.logging.Logger logger) {
  return withLogging(logger, java.util.logging.Level.WARNING);
}

    default BinaryOperatorWithThrowable<T, E> withLogging() {
  return withLogging(java.util.logging.Logger.getGlobal());
}

}
