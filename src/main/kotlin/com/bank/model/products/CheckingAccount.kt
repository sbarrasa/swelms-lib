package com.bank.model.products

import com.swelms.domain.id.cbu.CBU
import com.swelms.domain.locale.Currency
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName(CheckingAccount.TYPE_ID)
data class CheckingAccount(
   override val cbu: CBU,
   override val currency: Currency,
   override val creditLimit: Double
) : Product, Account, CreditProduct {
   companion object: ProductDescriptor {
      const val TYPE_ID = "CC"
      override val typeId get() = TYPE_ID
    }
}