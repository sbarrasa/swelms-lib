package com.sbarrasa.bank.product

import com.sbarrasa.bank.product.types.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ProductTest {

    @Test
    fun creditCardProduct() {
        val product = CreditCard().apply { branch = Branch.VISA}

        assertTrue(product.isCreditProduct)
        assertEquals(CreditCard.productType, product.productType)
        assertEquals(Branch.VISA, product.branch)
        assertEquals("${CreditCard.name} ${product.branch?.description}", product.description())

        product.tier = "GOLD"

        assertEquals("${CreditCard.name} ${product.branch?.description} GOLD", product.description())
    }

    @Test
    fun debitCard() {
        val product = DebitCard().apply { branch = Branch.MC}
        assertFalse(product.isCreditProduct)
        assertEquals(DebitCard.productType, product.productType)
        assertEquals(Branch.MC, product.branch)

    }

    @Test
    fun checkingAccount() {
        val product = CheckingAccount().apply { cbu="1234"; currency = Currency.USD}
        assertFalse(product.isCreditProduct)
        assertEquals(CheckingAccount.productType, product.productType)
        assertEquals("${CheckingAccount.name} en ${Currency.USD.description}", product.description())

    }

    @Test
    fun incompleteProduct() {
        val product = CheckingAccount()
        assertFalse(product.isCreditProduct)
        assertEquals("${CheckingAccount.name} en null", product.description())

    }

}