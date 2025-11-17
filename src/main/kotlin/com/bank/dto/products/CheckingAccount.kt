package com.bank.dto.products

import com.bank.dto.products.structure.Account
import com.bank.dto.products.structure.CreditProduct
import com.bank.dto.products.structure.Currency
import com.bank.dto.products.structure.ProductDescriptor
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName(CheckingAccount.TYPE)
data class CheckingAccount(
   override val cbu: String,
   override val currency: Currency,
   override val creditLimit: Double
) : Account(), CreditProduct {
   override val descriptor: ProductDescriptor get() = Companion

   companion object: ProductDescriptor {
      const val TYPE = "CC"
      override val id = TYPE
      override val description = "Cuenta corriente"
   }
}