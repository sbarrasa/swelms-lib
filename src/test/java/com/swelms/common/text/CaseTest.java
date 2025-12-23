package com.swelms.common.text;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CaseTest {

  @Test
  void test() {
    var value = StyleKt.toStyle("Hola Mundo", Style.Snake.INSTANCE);
    assertEquals("hola_mundo", value);
  }
}
