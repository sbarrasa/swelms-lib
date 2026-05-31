package swelms.common.locale

import swelms.common.text.replaceSlots
import kotlinx.datetime.LocalDate
import kotlinx.datetime.format
import kotlinx.datetime.format.*
import swelms.common.reflection.component
import swelms.domain.locale.Currency
import kotlin.test.*

class LocaleTest {
   @BeforeTest
   fun setup() {
      LocaleRegistry.langsMap.clear()
      LocaleRegistry.regionalsMap.clear()

      LocaleRegistry.register(regional_ar, lang_es, lang_en)
      LocaleContext.langId = "es"
      LocaleContext.regionalId = "ar"
   }

   @AfterTest
   fun teardown() {
      LocaleContext.langId = null
      LocaleContext.regionalId = null
      LocaleRegistry.langsMap.clear()
      LocaleRegistry.regionalsMap.clear()
   }

   @Test
   fun testLangText() {
      val result = LocaleContext.text("TEST")
      println("DEBUG: LocaleContext.lang = '${LocaleContext.langId}'")
      println("DEBUG: LocaleContext.regional = '${LocaleContext.regionalId}'")
      println("DEBUG: LocaleContext.currentLang = ${LocaleContext.lang}")
      println("DEBUG: LocaleContext.text('TEST') = '$result'")
      assertEquals("Prueba", result)
   }

   @Test
   fun testLangTextWithParams() {
      assertEquals("El valor debe estar entre 1 y 10", LocaleContext.text(component<LocaleContext>("OUT_OF_RANGE").replaceSlots(1, 10)))
   }

   @OptIn(FormatStringsInDatetimeFormats::class)
   @Test
   fun testValueString() {
      val dateFormat: String = LocaleContext.value("DATE_FORMAT")
      val formatter = LocalDate.Format { byUnicodePattern(dateFormat)}
      val date = LocalDate(2025, 11, 25)
      assertEquals("25/11/2025", date.format(formatter))
   }

   @Test
   fun testValueEnum() {
      val currency: Currency= LocaleContext.value("CURRENCY")
      assertEquals(Currency.ARS, currency)
   }


   @Test
   fun testNoValue() {
      assertEquals("NO_VALUE", LocaleContext.text("NO_VALUE"))
   }


   @Test
   fun testNolang() {
      LocaleContext.langId = null

      assertEquals("TEST", LocaleContext.text("TEST"))

   }

   @Test
   fun changeLang() {
      LocaleContext.langId = "en"
      assertEquals("Test", LocaleContext.text("TEST"))
      LocaleContext.langId = "es"
      assertEquals("Prueba", LocaleContext.text("TEST"))
   }

   @Test
   fun invalidValueClass(){
      assertFailsWith<ClassCastException>{
         LocaleContext.value<Int>("CURRENCY").toString()
      }
   }

   @Test
   fun invalidLang(){
      assertFailsWith<LocaleException>{ LocaleContext.langId = "xx" }
   }

   @Test
   fun componentNamed(){
      assertEquals("No hay artículos en stock", LocaleContext.text("NO_ITEMS"))
   }
}
