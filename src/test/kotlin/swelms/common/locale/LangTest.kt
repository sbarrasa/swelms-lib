package swelms.common.locale

import swelms.common.reflection.qProperty
import swelms.common.text.replaceSlots
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class LangTest {
   val currentContextProvider = Locale.contextProvider
   var lang_en = Lang(locale_id = "en_test") {
      it["GENERAL"] = "This is a general message"
      it["TEST"] = "Test"
      it[IntRange.qProperty("OUT_OF_RANGE")] = "Value must be between {1} and {2}"
      it["com.acme.stock.NEAR_EXPIRATION"] = "The product is near expiration"
   }

   val lang_es = Lang(locale_id = "es_test") {
      it["GENERAL"] = "Este es un mensaje general"
      it["TEST"] = "Prueba"
      it[IntRange.qProperty("OUT_OF_RANGE")] = "El valor debe estar entre {1} y {2}"
      it["com.acme.stock.NEAR_EXPIRATION"] = "El producto está cerca de vencer"
   }

   @BeforeTest
   fun setup() {
      val ctx = LocaleContext()
      Locale.contextProvider = { ctx }
   }

   @AfterTest
   fun shutdown() {
      Locale.contextProvider = currentContextProvider
   }

   @Test
   fun noRegister() {
      assertEquals("GENERAL", Locale.text("GENERAL"))
   }

   @Test
   fun stringLocale() {

      LocaleRegistry.register(lang_es, lang_en)
      Locale.langId = "en_test"
      assertEquals("This is a general message", "GENERAL".locale)

      Locale.langId = "es_test"
      assertEquals("Este es un mensaje general", "GENERAL".locale)
      assertEquals("El producto está cerca de vencer", "com.acme.stock.NEAR_EXPIRATION".locale)
      LocaleRegistry.unregister(lang_es, lang_en)

   }

   @Test
   fun propertyLocale() {

      LocaleRegistry.register(lang_es, lang_en)
      Locale.langId = "en_test"

      assertEquals("Value must be between 10 and 20",
                  Locale.text(IntRange.qProperty("OUT_OF_RANGE")).replaceSlots(10, 20)
      )
      LocaleRegistry.unregister(lang_es, lang_en)


   }

}