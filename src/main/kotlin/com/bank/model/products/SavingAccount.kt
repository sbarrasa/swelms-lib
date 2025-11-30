package com.bank.model.products

import com.bank.model.products.structure.Account
import com.bank.model.products.structure.ProductDescriptor
import com.swelms.domain.id.cbu.CBU
import com.swelms.domain.locale.Currency
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName(SavingAccount.TYPE)
data class SavingAccount(
   override val cbu: CBU,
   override val currency: Currency
) : Account() {
   companion object: ProductDescriptor {
      const val TYPE = "CA"
      override val type get() = TYPE
      override val description = "Caja de ahorro"
   }
}