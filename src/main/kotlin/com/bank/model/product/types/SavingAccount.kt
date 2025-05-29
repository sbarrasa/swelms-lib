package com.bank.model.product.types

import com.bank.model.product.factory.ProductRegister

class SavingAccount: Account(SavingAccount), CreditProduct {
    override var creditLimit: Double? = null
    companion object: ProductRegister<SavingAccount> {
        override var id = "CC"
        override val description = "Cuenta corriente"
        override val creator = ::SavingAccount
    }
}