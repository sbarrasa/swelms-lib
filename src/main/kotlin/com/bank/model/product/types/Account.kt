package com.bank.model.product.types

import com.bank.model.product.Currency
import com.bank.model.product.Product
import com.bank.model.product.ProductHeader

abstract class Account(header: ProductHeader) : Product(header) {
   var cbu: String? = null
   var currency: Currency? = null
   override fun fullDescription() = "${super.description} en ${currency?.description}"
}