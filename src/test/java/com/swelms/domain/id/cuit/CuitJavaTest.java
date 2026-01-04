package com.swelms.domain.id.cuit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CuitJavaTest {
  @Test
  void validTest() {
    var cuit = new Cuit("20240614708");
    assertEquals("20", cuit.getEntityCode());
    assertEquals("24061470", cuit.getDocument());
    assertEquals('8', cuit.getCheck());
  }

  @Test
  void invalidTest() {
    assertThrows(IllegalArgumentException.class, () -> new Cuit("20240614709"));
  }

  @Test
  void entityTypeTest() {
    var cuit = new Cuit("20240614708");
    assertEquals(Cuit.EntityType.PERSON, cuit.getEntityType());
  }
}

