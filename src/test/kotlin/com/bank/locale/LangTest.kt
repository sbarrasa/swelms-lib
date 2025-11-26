package com.bank.locale

import com.swelms.common.locale.*
import com.swelms.domain.cbu.CBU
import com.swelms.domain.cuit.Cuit
import com.swelms.domain.person.FullName
import kotlin.test.*

class LangTest {

   @Test
   fun testLang() {
      Locale.rootPackage = "com.bank.locale"

      val langs = listOf("en", "es", null)
      langs.forEach {
         Locale.lang = it
         println("$it: ${localeText["NOT_IMPLEMENTED"]}")
         println("$it: ${Cuit::class.localeText["INVALID_LENGTH"]}")
         println("$it: ${Locale.text(CBU::class)["INVALID_LENGTH"]}")
         println("$it: ${CBU.localeText["INVALID_LENGTH"]}")
         println("$it: ${FullName.localeText["INVALID_FORMAT"]}")

      }

   }
}