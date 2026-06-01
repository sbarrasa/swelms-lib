package swelms.common.locale

import swelms.domain.locale.Currency
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class RegionalTest {
   val currentContextProvider = Locale.contextProvider

   val regional_ar = Regional(locale_id = "ar_test") {
      it["CURRENCY"] = Currency.ARS
      it["DATE_FORMAT"] = "dd/MM/yyyy"
   }

   @BeforeTest
   fun setup() {
      val ctx = LocaleContext()
      Locale.contextProvider = { ctx }
      LocaleRegistry.register(regional_ar)
   }

   @AfterTest
   fun shutdown() {
      Locale.contextProvider = currentContextProvider
      LocaleRegistry.unregister(regional_ar)
   }

   @Test
   fun notRegistered(){
      Locale.regionalId = null
      val value = Locale.value<Currency>("CURRENCY")
      assertNull(value)
   }

   @Test
   fun valueString(){
      Locale.regionalId = "ar_test"
      assertEquals("dd/MM/yyyy", Locale.value("DATE_FORMAT"))
   }

   @Test
   fun valueObject() {
      Locale.regionalId = "ar_test"
      assertEquals(Currency.ARS, Locale.value("CURRENCY"))
   }
}

