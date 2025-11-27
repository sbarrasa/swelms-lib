package com.swelms.common.locale

import kotlin.test.*
import java.time.format.DateTimeFormatter
import java.time.LocalDate

class LocaleTest {
   init {
      Locale.rootPackage = "com.swelms.common.locale"
      Locale.lang = "es"
      Locale.regional = "ar"
   }

   @Test
   fun testLangText() {
      assertEquals("Prueba", localeText("TEST"))
   }

   @Test
   fun testLangTextWithParams() {
      assertEquals("El valor debe estar entre 1 y 10", Locale.text(IntRange::class, "OUT_OF_RANGE")(1, 10))
   }

   @Test
   fun testRegionalValue() {
      val formatter = Locale.valueOf<DateTimeFormatter>("DATE_FORMATTER")
      val formatted = formatter?.format(LocalDate.of(2025, 11, 25))
      assertEquals("25/11/2025", formatted)
   }

   @Test
   fun testNoValue() {
      assertEquals("NO_VALUE", Locale.text(IntRange::class, "NO_VALUE"))
   }

   @Test
   fun testFail() {
      val e = assertFailsWith<LocaleException> { Locale.text(IntRange::class, "clave inexistente", false) }
      assertEquals("NO_TEXT_FOUND", e.message)
   }

   @Test
   fun testNolang() {
      Locale.lang = null

      assertEquals("TEST", localeText("TEST"))
   }

   @Test
   fun registerOnTheFly() {
      Locale.currentLangConfig?.texts(Any::class) { it["MANUAL_TEST"] = "prueba manual" }
      assertEquals("prueba manual", localeText("MANUAL_TEST"))
   }

   @Test
   fun showAll() {
      Locale.printAll()
   }
}

