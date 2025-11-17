package com.bank.dto.products

import com.bank.dto.products.structure.Account
import com.bank.dto.products.structure.Currency
import com.bank.dto.products.structure.ProductDescriptor
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