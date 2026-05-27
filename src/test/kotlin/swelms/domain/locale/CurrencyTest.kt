package swelms.domain.locale

import swelms.common.locale.*import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class CurrencyTest {

   val lang_test = Lang(locale_id = "test"){
         component<Currency> {
            it["ARS"] = "Peso Argentino"
         }
   }

   @BeforeTest
   fun setup() {
      LocaleRegistry.register(lang_test)
      LocaleContext.default.langId = "test"
   }

   @AfterTest
   fun shutdown() {
      LocaleRegistry.unregister(lang_test)
   }

   @Test
   fun currencyProperties() {
      val ars = Currency.ARS
      assertEquals("$", ars.symbol)
      assertEquals("AR", ars.code)
      assertEquals("peso", ars.description)
   }

   @Test
   fun currencyLocaleDescription() {
      assertEquals("Peso Argentino", Currency.ARS.localeDescription)
      assertEquals("dollar", Currency.USD.localeDescription)
   }
}
