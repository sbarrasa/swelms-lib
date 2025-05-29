package com.bank.model.product.factory

import com.bank.model.product.Product
import com.bank.model.product.ProductHeader

interface ProductRegister<T: Product>: ProductHeader {
    val creator: ProductCreator<T>
}