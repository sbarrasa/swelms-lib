package com.bank.dto.product

import com.bank.product.structure.Account
import com.bank.product.structure.Currency
import com.bank.product.structure.ProductDescriptor
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