package com.bank.config

import com.bank.dto.product.factory.ProductFactory
import com.bank.dto.product.types.CheckingAccount
import com.bank.dto.product.types.CreditCard
import com.bank.dto.product.types.DebitCard
import com.bank.dto.product.types.SavingAccount

fun ProductFactory.init() {
   register { SavingAccount() }
   register { CheckingAccount() }
   register { CreditCard() }
   register { DebitCard() }
}