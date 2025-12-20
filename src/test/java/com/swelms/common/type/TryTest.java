package com.swelms.common.type;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class TryTest {
  @Test
  void testFail() {
    var a = 10;
    var b = 0;

    var value = Try.get( () -> a / b ).orElse(-1);

    assertEquals(-1, value);
  }

  @Test
  void testSuccess() {
    var a = 10;
    var b = 2;

    var value = Try.get( () -> a / b ).orElse(-1);
    assertEquals(5, value);
  }

  @Test
  void evalFail() {
    var a = 10;
    var b = 0;

    var result = Try.get( () -> a / b );
    assertTrue(result instanceof ValResult.Error);
  }

  @Test
  void evalSuccess() {
    var a = 10;
    var b = 2;

    var result = Try.get( () -> a / b );
    assertTrue(result instanceof ValResult.Success);
  }

}