package com.bank.model.product.factory

import com.bank.model.product.Product
import com.bank.model.product.types.CheckingAccount
import com.bank.model.product.types.CreditCard
import com.bank.model.product.types.DebitCard
import com.bank.model.product.types.SavingAccount
import kotlin.test.*

class ProductTypesTest {
   @BeforeTest
   fun init() {
      ProductFactory
         .register(SavingAccount)
         .register(CheckingAccount)
         .register(CreditCard)
         .register(DebitCard)
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