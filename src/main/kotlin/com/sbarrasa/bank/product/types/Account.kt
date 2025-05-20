package com.sbarrasa.bank.product.types

import com.sbarrasa.bank.product.Currency
import com.sbarrasa.bank.product.Product
import com.sbarrasa.bank.product.ProductHeader

abstract class Account(header: ProductHeader): Product(header) {
    var cbu: String? = null
    var currency: Currency? = null
    override fun description() = "${super.description()} en ${currency?.description}"
}