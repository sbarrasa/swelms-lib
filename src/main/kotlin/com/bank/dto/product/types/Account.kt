package com.bank.dto.product.types

import com.bank.dto.product.Currency
import com.bank.dto.product.Product
import com.bank.dto.product.ProductHeader

abstract class Account(header: ProductHeader) : Product(header) {
   var cbu: String? = null
   var currency: Currency? = null
   override fun fullDescription() = "$description en ${currency?.description}"
}