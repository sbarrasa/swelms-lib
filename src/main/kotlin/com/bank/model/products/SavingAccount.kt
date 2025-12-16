package com.bank.model.products

import com.swelms.domain.id.cbu.CBU
import com.swelms.domain.locale.Currency
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName(SavingAccount.TYPE_ID)
data class SavingAccount(
   override val cbu: CBU,
   override val currency: Currency
) : Product, Account {
   companion object: ProductDescriptor {
      const val TYPE_ID = "CA"
      override val typeId get() = TYPE_ID
   }
}