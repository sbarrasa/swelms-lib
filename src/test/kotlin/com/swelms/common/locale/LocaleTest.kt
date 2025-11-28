package com.swelms.common.locale

import kotlinx.datetime.LocalDate
import kotlinx.datetime.format
import kotlinx.datetime.format.*
import kotlin.test.*

class LocaleTest {
   init {
      Locale.registerConfigs(LocaleConfig_ar, LocaleConfig_es, LocaleConfig_en)
      Locale.lang = "es"
      Locale.regional = "ar"
   }

   @Test
   fun testLangText() {
      assertEquals("Prueba", localeText("TEST"))
   }

   @Test
   fun testLangTextWithParams() {
      assertEquals("El valor debe estar entre 1 y 10", Locale.text(IntRange::class, "OUT_OF_RANGE").replaceSlots(1, 10))
   }

   @OptIn(FormatStringsInDatetimeFormats::class)
   @Test
   fun testValueValue() {
      val dateFormat = Locale.value<String>("DATE_FORMAT")
      val formatter = LocalDate.Format { byUnicodePattern(dateFormat)}
      val date = LocalDate(2025, 11, 25)
      assertEquals("25/11/2025", date.format(formatter))
   }

   @Test
   fun testNoValue() {
      assertEquals("NO_VALUE", Locale.text(IntRange::class, "NO_VALUE"))
   }

   @Test
   fun testFail() {
      val e = assertFailsWith<LocaleException> { Locale.text(IntRange::class, "key", false) }
      assertEquals("NO_TEXT_FOUND key", e.message)
   }

   @Test
   fun testNolang() {
      Locale.lang = null

      assertEquals("TEST", localeText("TEST"))
   }

   @Test
   fun changeLang() {
      Locale.lang = "en"
      assertEquals("Test", localeText("TEST"))
      Locale.lang = "es"
      assertEquals("Prueba", localeText("TEST"))
   }

   @Test
   fun invalidValueClass(){
      assertFailsWith<ClassCastException>{
         Locale.value<Int>("CURRENCY").toString()
      }
   }

   @Test
   fun invalidLang(){
      assertFailsWith<LocaleException>{ Locale.lang = "xx" }
   }
}

