package com.sbarrasa.bank.product

import com.sbarrasa.bank.product.types.CreditProduct

abstract class Product(header: ProductHeader) : ProductHeader by header {
    val isCreditProduct = this is CreditProduct

    open fun description() = name
}