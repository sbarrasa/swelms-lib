package com.bank.services

import com.bank.model.products.CheckingAccount
import com.bank.model.products.CreditCard
import com.sbarrasa.registry.decodeFromMap
import com.bank.model.products.structure.Branch
import com.bank.model.products.structure.Currency
import com.bank.model.products.structure.Product
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.MissingFieldException
import kotlin.test.*

class ProductTypesTest {

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
           "cbu":"1234567890123456789012",
           "currency":"ARS", 
           "creditLimit":1000000
          }
          """.trimIndent()

      val product = ProductTypes.json.decodeFromString<Product>(jsonString)

      assertTrue(product is CheckingAccount)
      assertEquals("1234567890123456789012", product.cbu)
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

      val product = ProductTypes.json.decodeFromMap<Product>(map)

      assertTrue(product is CreditCard)
      assertEquals(Branch.VISA, product.branch)
      assertEquals(5000000.0, product.creditLimit)
      assertEquals("Tarjeta de crédito VISA Black", product.description)


   }

   @ExperimentalSerializationApi
   @Test
   fun createFromMapWithInvalidaData() {
      val map = mapOf(
         "id" to "TC",
      )

      val e = assertFailsWith<MissingFieldException> { ProductTypes.json.decodeFromMap<Product>(map) }
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

      val product = ProductTypes.json.decodeFromMap<Product>(map)

      assertEquals(CreditCard::class, product::class)
      assertEquals(CreditCard.id, product.descriptor?.id)
      assertEquals(CreditCard.description, product.descriptor?.description)


   }
}

