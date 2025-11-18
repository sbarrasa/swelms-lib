package com.bank.model.products

import com.bank.model.products.structure.Account
import com.bank.model.products.structure.Currency
import com.bank.model.products.structure.ProductDescriptor
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName(SavingAccount.TYPE)
data class SavingAccount(
   override val cbu: String,
   override val currency: Currency
) : Account() {
   companion object: ProductDescriptor {
      const val TYPE = "CA"
      override val id get() = TYPE
      override val description = "Caja de ahorro"
   }
}