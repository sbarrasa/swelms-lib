package com.bank.dto.product.types

import com.bank.dto.product.ProductHeader

class DebitCard : Card(DebitCard) {
   companion object : ProductHeader {
      override var id = "TD"
      override val description = "Tarjeta de débito"
   }
}