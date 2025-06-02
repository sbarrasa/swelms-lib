package com.bank.model.product

import com.bank.model.product.types.CheckingAccount
import com.bank.model.product.types.CreditCard
import com.bank.model.product.types.DebitCard
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ProductTest {

   @Test
   fun creditCardProduct() {
      val product = CreditCard().apply { branch = Branch.VISA }

      assertTrue(product.isCreditProduct)
      assertEquals(CreditCard.description, product.description)
      assertEquals(Branch.VISA, product.branch)
      assertEquals("${CreditCard.description} ${product.branch?.description}", product.fullDescription())

      product.tier = "GOLD"

      assertEquals("${CreditCard.description} ${product.branch?.description} GOLD", product.fullDescription())
   }

   @Test
   fun debitCard() {
      val product = DebitCard().apply { branch = Branch.MC }
      assertFalse(product.isCreditProduct)
      assertEquals(DebitCard.description, product.description)
      assertEquals(Branch.MC, product.branch)

   }

   @Test
   fun checkingAccountUSD() {
      val product = CheckingAccount().apply { cbu = "1234"; currency = Currency.USD }
      assertFalse(product.isCreditProduct)
      assertEquals(CheckingAccount.description, product.description)
      assertEquals("${CheckingAccount.description} en ${Currency.USD.description}", product.fullDescription())
   }

   @Test
   fun checkingAccountARS() {
      val product2 = CheckingAccount().apply { cbu = "5678"; currency = Currency.ARS }
      assertEquals(Currency.ARS, product2.currency)
   }

   @Test
   fun incompleteProduct() {
      val product = CheckingAccount()
      assertFalse(product.isCreditProduct)
      assertEquals("${CheckingAccount.description} en null", product.fullDescription())

   }

}