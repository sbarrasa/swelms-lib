package com.swelms.common.locale

import kotlin.test.*
import java.time.format.DateTimeFormatter
import java.time.LocalDate

class LocaleFullTest {
   init{
      Locale.rootPackage = "com.swelms.common.locale"
      Locale.lang = "es"
      Locale.regional = "ar"
   }

   @Test
   fun testLangText() {
      assertEquals("Prueba", localeText["TEST"])
   }

   @Test
   fun testLangTextWithParams() {
      assertEquals("El valor debe estar entre 1 y 10", localeText["OUT_OF_RANGE"](1,10))
   }

   @Test
   fun testRegionalValue() {
      val formatter = Locale.valueOf<DateTimeFormatter>("DATE_FORMATTER")
      val formatted = formatter?.format(LocalDate.of(2025,11,25))
      assertEquals("25/11/2025", formatted)
   }
}
