package com.bank.dto.product

import com.bank.product.structure.Account
import com.bank.product.structure.Currency
import com.bank.product.structure.ProductDescriptor
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("CA")
data class SavingAccount(
   override val cbu: String,
   override val currency: Currency
) : Account() {
   override val descriptor: ProductDescriptor
      get() = Companion

   companion object: ProductDescriptor {
      override var id = "CA"
      override val description = "Caja de ahorro"
   }
}