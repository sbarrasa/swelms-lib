package com.swelms.common.locale

import com.swelms.common.locale.lang.es.LocaleConfig
import kotlin.test.*
import java.time.format.DateTimeFormatter
import java.time.LocalDate

class LocaleFullTest {
   init{
      Locale.rootPackage = "com.swelms.common.locale"
      Locale.currentLangConfig = Locale.load(LocaleConfig) as AbstractLangConfig
      Locale.currentRegionalConfig = Locale.load(com.swelms.common.locale.regional.ar.LocaleConfig) as AbstractRegionalConfig
 }

   @Test
   fun testLangText() {
      assertEquals("Inicio", localeText["INIT"])
      assertEquals("Fin", localeText["END"])

   }

   @Test
   fun testRegionalValue() {
      val formatter = Locale.valueOf<DateTimeFormatter>("DATE_FORMATTER")
      val formatted = formatter?.format(LocalDate.of(2025,11,25))
      assertEquals("25/11/2025", formatted)
   }
}
