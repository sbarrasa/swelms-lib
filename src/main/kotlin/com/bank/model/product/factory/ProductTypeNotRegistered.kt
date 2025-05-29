package com.bank.model.product.factory

class ProductTypeNotRegistered(
    val productType: String,
    override val message: String = "Producto no registrado $productType"
): RuntimeException(message)
