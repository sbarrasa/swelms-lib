package com.bank.config

import com.bank.product.registry.ProductRegistry
import com.bank.dto.product.CheckingAccount
import com.bank.dto.product.CreditCard
import com.bank.dto.product.DebitCard
import com.bank.dto.product.SavingAccount

object ProductTypes : ProductRegistry() {

   init {
      register(CheckingAccount::class)
      register( SavingAccount::class)
      register(CreditCard::class)
      register( DebitCard::class)
   }
}