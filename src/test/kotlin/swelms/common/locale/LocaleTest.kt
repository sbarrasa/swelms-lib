package swelms.common.locale

import swelms.common.reflection.qName
import swelms.common.text.replaceSlots
import kotlinx.datetime.LocalDate
import kotlinx.datetime.format
import kotlinx.datetime.format.*
import swelms.domain.locale.Currency
import kotlin.test.*

class LocaleTest {
   @BeforeTest
   fun setup() {
      Locale.langsMap.clear()
      Locale.regionalsMap.clear()

      Locale.register(regional_ar, lang_es, lang_en)
      Locale.curLangId = "es"
      Locale.curRegionalId = "ar"
   }

   @AfterTest
   fun teardown() {
      Locale.curLangId = null
      Locale.curRegionalId = null
      Locale.langsMap.clear()
      Locale.regionalsMap.clear()
   }

   @Test
   fun testLangText() {
      val result = localeText("TEST")
      println("DEBUG: Locale.lang = '${Locale.curLangId}'")
      println("DEBUG: Locale.regional = '${Locale.curRegionalId}'")
      println("DEBUG: Locale.currentLang = ${Locale.curLang}")
      println("DEBUG: localeText('TEST') = '$result'")
      assertEquals("Prueba", result)
   }

   @Test
   fun testLangTextWithParams() {
      assertEquals("El valor debe estar entre 1 y 10", Locale.text(IntRange::class.qName, "OUT_OF_RANGE").replaceSlots(1, 10))
   }

   @OptIn(FormatStringsInDatetimeFormats::class)
   @Test
   fun testValueString() {
      val dateFormat: String = Locale.value("DATE_FORMAT")
      val formatter = LocalDate.Format { byUnicodePattern(dateFormat)}
      val date = LocalDate(2025, 11, 25)
      assertEquals("25/11/2025", date.format(formatter))
   }

   @Test
   fun testValueEnum() {
      val currency: Currency= Locale.value("CURRENCY")
      assertEquals(Currency.ARS, currency)
   }


   @Test
   fun testNoValue() {
      assertEquals("NO_VALUE", Locale.text(IntRange::class.qName, "NO_VALUE"))
   }


   @Test
   fun testNolang() {
      Locale.curLangId = null

      assertEquals("TEST", localeText("TEST"))

   }

   @Test
   fun changeLang() {
      Locale.curLangId = "en"
      assertEquals("Test", localeText("TEST"))
      Locale.curLangId = "es"
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
      assertFailsWith<LocaleException>{ Locale.curLangId = "xx" }
   }

   @Test
   fun componentNamed(){
      assertEquals("No hay artículos en stock", Locale.text("stock", "NO_ITEMS"))
   }
}
