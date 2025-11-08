package com.bank.model.product.types

import com.bank.model.product.ProductHeader

class DebitCard : Card(DebitCard) {
   companion object : ProductHeader {
      override var id = "TD"
      override val description = "Tarjeta de débito"
   }
}