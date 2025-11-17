package com.bank.dto.product

import com.bank.product.structure.Account
import com.bank.product.structure.Currency
import com.bank.product.structure.ProductDescriptor
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName(SavingAccount.type)
data class SavingAccount(
   override val cbu: String,
   override val currency: Currency
) : Account() {

   companion object: ProductDescriptor {
      const val type = "CA"
      override var id = type
      override val description = "Caja de ahorro"
   }
}