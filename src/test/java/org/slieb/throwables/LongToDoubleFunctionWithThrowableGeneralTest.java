package org.slieb.throwables;

import org.junit.Test;
import java.util.concurrent.atomic.AtomicReference;
import static org.slieb.throwables.LongToDoubleFunctionWithThrowable.castLongToDoubleFunctionWithThrowable;
import static org.junit.Assert.assertEquals;
public class LongToDoubleFunctionWithThrowableGeneralTest {
 @Test
 public void testOnException() {
        AtomicReference<java.lang.Throwable> reference = new AtomicReference<>();
        java.lang.Exception expected = new java.lang.Exception("expected");
        try {
        castLongToDoubleFunctionWithThrowable((v1) -> {
      throw expected;
    }).onException(reference::set).applyAsDouble(0);
        } catch (Throwable ignored) {}
        assertEquals(expected, reference.get());
 }

}
