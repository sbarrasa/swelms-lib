package com.bank.dto.product

import com.bank.product.structure.Account
import com.bank.product.structure.CreditProduct
import com.bank.product.structure.Currency
import com.bank.product.structure.ProductDescriptor
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName(CheckingAccount.type)
data class CheckingAccount(
   override val cbu: String,
   override val currency: Currency,
   override val creditLimit: Double
) : Account(), CreditProduct {

   companion object: ProductDescriptor {
      const val type = "CC"
      override var id = type
      override val description = "Cuenta corriente"
   }
}