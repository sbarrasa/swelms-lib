package com.bank.dto.product

import com.bank.dto.product.types.CreditProduct

abstract class Product(header: ProductHeader) : ProductHeader by header {
   val isCreditProduct = (this is CreditProduct)
   abstract fun fullDescription(): String
}