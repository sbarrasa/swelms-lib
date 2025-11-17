package com.bank.dto.product.types

import com.bank.dto.product.ProductDescriptor

class DebitCard : Card(DebitCard) {
   companion object : ProductDescriptor {
      override var id = "TD"
      override val description = "Tarjeta de débito"
   }
}