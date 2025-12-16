package com.bank.model.products

import com.bank.locale.lang_en
import com.bank.locale.lang_es
import com.swelms.common.locale.Locale
import com.swelms.domain.id.card.CardNumber
import com.swelms.domain.id.cbu.CBU
import com.swelms.domain.locale.Currency
import kotlinx.datetime.LocalDate
import kotlin.reflect.full.companionObjectInstance
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull


class ProductTest {
   init {
      Locale.registerConfigs(lang_es, lang_en)
      Locale.lang = "es"
   }

   @Test
   fun listProducts() {
      Product.types.forEach {
         val descriptor = it.companionObjectInstance as? ProductDescriptor
         with(descriptor!!){
            println("$type: $description")
         }
      }
   }


   @Test
   fun createCheckingAccount() {
      val map = mapOf(
         "cbu" to CBU("2850590940090418135201"),
         "currency" to Currency.ARS,
         "creditLimit" to 1000.0
      )
      val checking = Product.create<CheckingAccount>(map)
      assertNotNull(checking)
      assertEquals(Currency.ARS, checking.currency)
      assertEquals(1000.0, checking.creditLimit)
   }

   @Test
   fun createCreditCardProduct() {
      val map = mapOf(
         "cardNumber" to CardNumber("1111222233334444"),
         "expirationDate" to LocalDate(2025, 12, 31),
         "creditLimit" to 5000.0,
         "tier" to "Gold"
      )
      val creditCard = Product.create<CreditCardProduct>(map)
      assertNotNull(creditCard)
      assertEquals("1111222233334444", creditCard.cardNumber.value)
      assertEquals(5000.0, creditCard.creditLimit)
      assertEquals("Gold", creditCard.tier)
   }


}

