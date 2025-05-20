package com.sbarrasa.bank.product.factory

import com.sbarrasa.bank.product.Product
import com.sbarrasa.bank.product.types.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ProductRegistryTest{
    @BeforeEach
    fun init(){
        ProductRegistry
            .register(SavingAccount)
            .register(CheckingAccount)
            .register(CreditCard)
            .register(DebitCard)
    }

    @Test
    fun unknownProductType() {
        assertThrows<ProductTypeNotRegistered>{ProductRegistry.create<Product>("HOLA")}

    }

    @Test
    fun invalidCastProductType() {
        assertThrows<ClassCastException> {
            val product: SavingAccount = ProductRegistry.create("TC")
            assertTrue(product.isCreditProduct)
        }

    }

    @Test
    fun createSavingAccount() {
        assertDoesNotThrow { ProductRegistry.create<SavingAccount>("CC")}
    }

    @Test
    fun createCheckingAccount() {
        assertDoesNotThrow { ProductRegistry.create<CheckingAccount>("CA")}
    }

    @Test
    fun createCreditCard() {
        assertDoesNotThrow { ProductRegistry.create<CreditCard>("TC")}
    }

    @Test
    fun createDebitCard() {
        assertDoesNotThrow{ProductRegistry.create<DebitCard>("TD")}
    }
}