package com.bank.modules

import com.bank.model.product.factory.ProductRegistry
import com.bank.model.product.types.*

fun ProductRegistry.init(){
   register(SavingAccount)
   register(CheckingAccount)
   register(CreditCard)
   register(DebitCard)
}