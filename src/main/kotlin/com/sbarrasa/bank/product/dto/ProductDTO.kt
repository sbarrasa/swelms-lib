package com.sbarrasa.bank.product.dto

data class ProductDTO(val productType: String) {
    val attributes = HashMap<String, Any>()
    operator fun set(key: String, value: Any): ProductDTO {
        attributes[key] = value
        return this
    }
}