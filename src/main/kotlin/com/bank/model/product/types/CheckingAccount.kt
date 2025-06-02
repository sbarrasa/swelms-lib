package com.bank.model.product.types

import com.bank.model.product.factory.ProductRegister

class CheckingAccount : Account(CheckingAccount) {
   companion object : ProductRegister<CheckingAccount> {
      override var id = "CA"
      override val description = "Caja de ahorro"
      override val creator = ::CheckingAccount
   }
}