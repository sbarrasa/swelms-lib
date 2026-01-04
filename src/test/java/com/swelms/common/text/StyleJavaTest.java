package com.swelms.common.text;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StyleJavaTest {

  @Test
  void test() {
    var value = StyleKt.applyStyle("hola mundo", Style.SNAKE);
    assertEquals("hola_mundo", value);
  }
}
