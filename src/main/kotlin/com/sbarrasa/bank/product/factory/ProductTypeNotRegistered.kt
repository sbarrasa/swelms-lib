package com.sbarrasa.bank.product.factory

class ProductTypeNotRegistered(productType: String) : RuntimeException("Producto no registrado ${productType}") {

}
