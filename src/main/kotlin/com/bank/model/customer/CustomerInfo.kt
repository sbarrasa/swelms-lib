package com.bank.model.customer

import com.swelms.domain.cuit.Cuit
import kotlinx.serialization.Serializable

@Serializable
data class CustomerInfo(val customer: Customer) {
   val entityType: Cuit.EntityType? = customer.cuit?.entityType
}