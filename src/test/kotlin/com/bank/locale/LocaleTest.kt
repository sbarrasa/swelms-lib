package com.bank.locale

import com.sbarrasa.common.locale.Locale
import kotlin.test.*

class LocaleTest {
   @Test
   fun testLang() {
      Locale.rootPackage = "com.bank.locale"

      val langs = listOf("en", "es", null)
      langs.forEach {
         Locale.lang = it
         println("$it: ${Locale.text(Any::class)["NOT_IMPLEMENTED"]}")

      }

   }
}