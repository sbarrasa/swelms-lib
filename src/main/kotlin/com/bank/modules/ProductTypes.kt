package com.bank.modules

import com.bank.model.product.factory.ProductFactory
import com.bank.model.product.types.CheckingAccount
import com.bank.model.product.types.CreditCard
import com.bank.model.product.types.DebitCard
import com.bank.model.product.types.SavingAccount

fun ProductFactory.init() {
   register(SavingAccount)
   register(CheckingAccount)
   register(CreditCard)
   register(DebitCard)
}