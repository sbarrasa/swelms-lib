package com.bank.model.customer

import kotlinx.serialization.Serializable

@Serializable
data class CustomerInfo(val customer: Customer) {
   val entityType: String? = customer.cuit?.entityType?.description
}