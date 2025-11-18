package com.bank.services

import com.bank.model.products.CheckingAccount
import com.bank.model.products.CreditCard
import com.sbarrasa.serialization.json.decodeFromMap
import com.bank.model.products.structure.CardBranch
import com.bank.model.products.structure.Currency
import com.bank.model.products.structure.Product
import com.sbarrasa.legal.cbu.*
import com.sbarrasa.serialization.modules.polymorphic
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.MissingFieldException
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlin.test.*

class ProductTypesTest {
   val json = Json {
      serializersModule = SerializersModule {
         polymorphic(ProductTypes)
      }
      classDiscriminator = "id"
      ignoreUnknownKeys = true
   }

   @Test
   fun asMap() {
      val map = ProductTypes.asMap()

      assertTrue(map.containsKey("CC"))
      assertTrue(map.containsKey("TC"))
   }

   @Test
   fun getDescriptor() {
      val descriptor = ProductTypes.getDescriptor(CheckingAccount::class)

      assertEquals("CC", descriptor?.id)
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
         "branch" to "VISA",
         "number" to "4111111111111111",
         "expirationDate" to "2025-12-31",
         "creditLimit" to "5000000.00",
         "tier" to "Black"
      )

      val product = json.decodeFromMap<Product>(map)

      assertTrue(product is CreditCard)
      assertEquals(CardBranch.VISA, product.branch)
      assertEquals(5000000.0, product.creditLimit)
      assertEquals("Tarjeta de crédito VISA Black", product.description)


   }

   @ExperimentalSerializationApi
   @Test
   fun createFromMapWithInvalidaData() {
      val map = mapOf(
         "id" to "TC",
      )

      val e = assertFailsWith<MissingFieldException> { json.decodeFromMap<Product>(map) }
      assertContains(e.message?:"","branch")
   }

   @Test
   fun compareDescriptor() {
      val map = mapOf(
         "id" to "TC",
         "branch" to "VISA",
         "number" to "4111111111111111",
         "expirationDate" to "2025-12-31",
         "creditLimit" to "5000000.00",
         "tier" to "Black"
      )

      val product = json.decodeFromMap<Product>(map)

      assertEquals(CreditCard::class, product::class)
      assertEquals(CreditCard.id, product.descriptor?.id)
      assertEquals(CreditCard.description, product.descriptor?.description)

   }
}

