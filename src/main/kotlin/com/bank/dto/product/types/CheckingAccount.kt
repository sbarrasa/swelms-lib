package com.bank.dto.product.types

import com.bank.dto.product.ProductDescriptor

class CheckingAccount : Account(CheckingAccount) {
   companion object : ProductDescriptor {
      override var id = "CA"
      override val description = "Caja de ahorro"
   }
}