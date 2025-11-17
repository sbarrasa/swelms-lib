package com.product

import com.bank.config.ProductTypes
import com.bank.dto.product.CheckingAccount
import com.bank.dto.product.CreditCard
import com.sbarrasa.registry.decodeFromMap
import com.bank.product.structure.Branch
import com.bank.product.structure.Currency
import com.bank.product.structure.Product
import kotlin.test.*

class ProductTypeTest {

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
      val jsonString = """{"id":"CC","cbu":"1234567890123456789012","currency":"ARS", "creditLimit":1000000}"""

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

   }


}
