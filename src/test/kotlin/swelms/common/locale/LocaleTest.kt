package swelms.common.locale

import swelms.common.text.replaceSlots
import kotlinx.datetime.LocalDate
import kotlinx.datetime.format
import kotlinx.datetime.format.*
import swelms.domain.locale.Currency
import kotlin.test.*

class LocaleTest {
   @BeforeTest
   fun setup() {
      LocaleRegistry.langsMap.clear()
      LocaleRegistry.regionalsMap.clear()

      LocaleRegistry.register(regional_ar, lang_es, lang_en)
      LocaleContext.default.langId = "es"
      LocaleContext.default.regionalId = "ar"
   }

   @AfterTest
   fun teardown() {
      LocaleContext.default.langId = null
      LocaleContext.default.regionalId = null
      LocaleRegistry.langsMap.clear()
      LocaleRegistry.regionalsMap.clear()
   }

   @Test
   fun testLangText() {
      val result = localeText("TEST")
      println("DEBUG: LocaleContext.default.lang = '${LocaleContext.default.langId}'")
      println("DEBUG: LocaleContext.default.regional = '${LocaleContext.default.regionalId}'")
      println("DEBUG: LocaleContext.default.currentLang = ${LocaleContext.default.lang}")
      println("DEBUG: localeText('TEST') = '$result'")
      assertEquals("Prueba", result)
   }

   @Test
   fun testLangTextWithParams() {
      assertEquals("El valor debe estar entre 1 y 10", LocaleContext.default.text(IntRange::class.qualifiedName!!, "OUT_OF_RANGE").replaceSlots(1, 10))
   }

   @OptIn(FormatStringsInDatetimeFormats::class)
   @Test
   fun testValueString() {
      val dateFormat: String = LocaleContext.default.value("DATE_FORMAT")
      val formatter = LocalDate.Format { byUnicodePattern(dateFormat)}
      val date = LocalDate(2025, 11, 25)
      assertEquals("25/11/2025", date.format(formatter))
   }

   @Test
   fun testValueEnum() {
      val currency: Currency= LocaleContext.default.value("CURRENCY")
      assertEquals(Currency.ARS, currency)
   }


   @Test
   fun testNoValue() {
      assertEquals("NO_VALUE", LocaleContext.default.text(IntRange::class.qualifiedName!!, "NO_VALUE"))
   }


   @Test
   fun testNolang() {
      LocaleContext.default.langId = null

      assertEquals("TEST", localeText("TEST"))

   }

   @Test
   fun changeLang() {
      LocaleContext.default.langId = "en"
      assertEquals("Test", localeText("TEST"))
      LocaleContext.default.langId = "es"
      assertEquals("Prueba", localeText("TEST"))
   }

   @Test
   fun invalidValueClass(){
      assertFailsWith<ClassCastException>{
         LocaleContext.default.value<Int>("CURRENCY").toString()
      }
   }

   @Test
   fun invalidLang(){
      assertFailsWith<LocaleException>{ LocaleContext.default.langId = "xx" }
   }

   @Test
   fun componentNamed(){
      assertEquals("No hay artículos en stock", LocaleContext.default.text("stock", "NO_ITEMS"))
   }
}
