package com.bank.products

import com.bank.products.structure.Account
import com.bank.products.structure.Currency
import com.bank.products.structure.ProductDescriptor
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName(SavingAccount.TYPE)
data class SavingAccount(
   override val cbu: String,
   override val currency: Currency
) : Account() {
   override val descriptor: ProductDescriptor
      get() = Companion

   companion object: ProductDescriptor {
      const val TYPE = "CA"
      override val id = TYPE
      override val description = "Caja de ahorro"
   }
}