package com.bank.dto.product.types

import com.bank.dto.product.ProductHeader

class CheckingAccount : Account(CheckingAccount) {
   companion object : ProductHeader {
      override var id = "CA"
      override val description = "Caja de ahorro"
   }
}