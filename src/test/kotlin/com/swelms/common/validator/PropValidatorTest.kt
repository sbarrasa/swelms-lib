package com.swelms.common.validator

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails


class PropValidatorTest {
   @Test
   fun test() {
      var name: String? = null

      val validator = { name } mustBe { !it.isNullOrBlank() }

      assertFails { validator.validate() }

      name = "Juan"
      assertEquals("Juan", validator.validate())

   }




}