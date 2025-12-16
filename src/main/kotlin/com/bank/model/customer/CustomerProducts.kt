package com.bank.model.customer

import com.bank.model.products.Product
import kotlinx.serialization.Serializable

@Serializable
data class CustomerProducts(
   val customer: Customer,
   val products: List<Product> = mutableListOf()
)