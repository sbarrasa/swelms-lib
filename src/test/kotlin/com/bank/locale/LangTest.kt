package com.bank.locale

import com.sbarrasa.common.locale.*
import com.sbarrasa.domain.cbu.CBU
import com.sbarrasa.domain.cuit.Cuit
import com.sbarrasa.domain.person.NameUtils
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
         println("$it: ${NameUtils.localeText["INVALID_FORMAT"]}")

      }

   }
}