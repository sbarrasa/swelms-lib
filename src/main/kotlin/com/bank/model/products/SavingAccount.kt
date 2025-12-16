package com.bank.model.products

import com.bank.model.products.Account
import com.bank.model.products.Product
import com.bank.model.products.ProductDescriptor
import com.swelms.domain.id.cbu.CBU
import com.swelms.domain.locale.Currency
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName(SavingAccount.TYPE)
data class SavingAccount(
   override val cbu: CBU,
   override val currency: Currency
) : Product, Account {
   companion object: ProductDescriptor {
      const val TYPE = "CA"
      override val type get() = TYPE
   }
}