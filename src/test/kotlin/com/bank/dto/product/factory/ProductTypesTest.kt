package com.bank.dto.product.factory

import com.bank.dto.product.Product
import com.bank.dto.product.types.CheckingAccount
import com.bank.dto.product.types.CreditCard
import com.bank.dto.product.types.DebitCard
import com.bank.dto.product.types.SavingAccount
import kotlin.test.*

class ProductTypesTest {
   @BeforeTest
   fun init() {
      with(ProductFactory) {
         register { SavingAccount() }
         register { CheckingAccount() }
         register { CreditCard() }
         register { DebitCard() }
      }
   }

   @Test
   fun unknownProductType() {
      assertFailsWith<ProductTypeNotRegistered> { ProductFactory.create<Product>("HOLA") }
   }

   @Test
   fun invalidCastProductType() {
      assertFailsWith<ClassCastException> {
         val product: SavingAccount = ProductFactory.create("TC")
         assertTrue(product.isCreditProduct)
      }

   }

   @Test
   fun createSavingAccount() {
      val product = ProductFactory.create<SavingAccount>("CC")
      assertEquals("CC", product.id)
   }

   @Test
   fun asMap() {
      println(ProductFactory.asMap())
   }
}