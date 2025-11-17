package com.bank.dto.product.types

import com.bank.dto.product.ProductDescriptor

class SavingAccount : Account(SavingAccount), CreditProduct {
   override var creditLimit: Double? = null

   companion object : ProductDescriptor {
      override var id = "CC"
      override val description = "Cuenta corriente"
   }
}