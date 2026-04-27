package com.swelms.domain.locale

import com.swelms.common.locale.LangInterface
import com.swelms.common.locale.Locale
import com.swelms.common.reflection.qName
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class CurrencyTest {

   object CurrencyLang : LangInterface {
      override val locale_id = "test"
      override val moduleTextMap = mapOf(
         Currency::class.qName to mutableMapOf(
            "ARS" to "Peso Argentino"
         )
      )
   }

   @BeforeTest
   fun setup() {
      Locale.register(CurrencyLang)
      Locale.lang = "test"
   }

   @AfterTest
   fun shutdown() {
      Locale.unregister(CurrencyLang)
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
