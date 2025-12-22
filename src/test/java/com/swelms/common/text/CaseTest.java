package com.swelms.common.text;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CaseTest {

  @Test
  void test() {
    var value = CaseKt.toCase("Hola Mundo", Case.SNAKE.INSTANCE);
    assertEquals("hola_mundo", value);
  }
}
