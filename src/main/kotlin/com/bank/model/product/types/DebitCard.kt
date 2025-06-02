package com.bank.model.product.types

import com.bank.model.product.factory.ProductRegister

class DebitCard : Card(DebitCard) {
   companion object : ProductRegister<DebitCard> {
      override var id = "TD"
      override val description = "Tarjeta de débito"
      override val creator = ::DebitCard
   }
}