package com.bank.dto.product.types

import com.bank.dto.product.ProductHeader

class SavingAccount : Account(SavingAccount), CreditProduct {
   override var creditLimit: Double? = null

   companion object : ProductHeader {
      override var id = "CC"
      override val description = "Cuenta corriente"
   }
}