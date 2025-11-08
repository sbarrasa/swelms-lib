package com.bank.model.product.types

import com.bank.model.product.ProductHeader

class CheckingAccount : Account(CheckingAccount) {
   companion object : ProductHeader {
      override var id = "CA"
      override val description = "Caja de ahorro"
   }
}