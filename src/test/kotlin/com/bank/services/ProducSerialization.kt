package com.bank.services

import com.bank.model.products.CheckingAccount
import com.bank.model.products.CreditCardProduct
import com.swelms.common.serialization.decodeFromMap
import com.swelms.domain.locale.Currency
import com.bank.model.products.Product
import com.swelms.domain.id.card.CardBrand
import com.swelms.common.serialization.polymorphic
import com.swelms.domain.id.cbu.CBU
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.MissingFieldException
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlin.test.*

class ProducSerialization {

   val json = Json {
      serializersModule = SerializersModule {
         polymorphic(Product::class)
      }
      classDiscriminator = "id"
      ignoreUnknownKeys = true
   }


   @Test
   fun getDescriptor() {
      val descriptor = CheckingAccount

      assertEquals("CC", descriptor.type)
   }


   @Test
   fun createFromJsonString() {
     val jsonString = """
         {
           "id":"CC",
           "cbu":"0000003100001780089447",
           "currency":"ARS", 
           "creditLimit":1000000
          }
          """.trimIndent()

      val product = json.decodeFromString<Product>(jsonString)

      assertTrue(product is CheckingAccount)
      assertEquals(CBU("0000003100001780089447"), product.cbu)
      assertEquals(Currency.ARS, product.currency)
   }


   @Test
   fun createFromMap() {
      val map = mapOf(
         "id" to "TC",
         "cardNumber" to "4111111111111111",
         "expirationDate" to "2025-12-31",
         "creditLimit" to "5000000.00",
         "tier" to "Black"
      )

      val product = json.decodeFromMap<Product>(map)

      assertTrue(product is CreditCardProduct)
      assertEquals(CardBrand.VISA, product.cardNumber.brand)
      assertEquals(5000000.0, product.creditLimit)
   }

   @ExperimentalSerializationApi
   @Test
   fun createFromMapWithInvalidaData() {
      val map = mapOf(
         "id" to "TC",
      )

      val e = assertFailsWith<MissingFieldException> { json.decodeFromMap<Product>(map) }
      assertContains(e.message?:"","cardNumber")
   }

   @Test
   fun compareDescriptor() {
      val map = mapOf(
         "id" to "TC",
         "cardNumber" to "4111111111111111",
         "expirationDate" to "2025-12-31",
         "creditLimit" to "5000000.00",
         "tier" to "Black"
      )

      val product = json.decodeFromMap<Product>(map)

      assertEquals(CreditCardProduct::class, product::class)
      assertEquals(CreditCardProduct.type, product.descriptor?.type)
      assertEquals(CreditCardProduct.description, product.descriptor?.description)

   }
}

