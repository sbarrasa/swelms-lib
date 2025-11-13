package com.bank.dto.customer

import kotlinx.serialization.Serializable

@Serializable
data class CustomerInfo(val customer: Customer) {
   val entityType: String? = customer.cuit?.entityType?.description
}