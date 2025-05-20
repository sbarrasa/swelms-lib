package com.sbarrasa.bank.product.types

import com.sbarrasa.bank.product.factory.ProductRegister

class SavingAccount: Account(SavingAccount), CreditProduct {
    override var creditLimit: Double? = null
    companion object: ProductRegister<SavingAccount> {
        override val productType = "CC"
        override val name = "Cuenta corriente"
        override val creator = ::SavingAccount
    }
}