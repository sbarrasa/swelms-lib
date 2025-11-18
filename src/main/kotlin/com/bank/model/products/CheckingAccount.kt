package com.bank.model.products

import com.bank.model.products.structure.Account
import com.bank.model.products.structure.CreditProduct
import com.bank.model.products.structure.Currency
import com.bank.model.products.structure.ProductDescriptor
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName(CheckingAccount.TYPE)
data class CheckingAccount(
   override val cbu: String,
   override val currency: Currency,
   override val creditLimit: Double
) : Account(), CreditProduct {
     companion object: ProductDescriptor {
      const val TYPE = "CC"
      override val id get() = TYPE
      override val description = "Cuenta corriente"
   }
}