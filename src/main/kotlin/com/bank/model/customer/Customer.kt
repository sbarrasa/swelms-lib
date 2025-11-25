package com.bank.model.customer

import com.swelms.domain.cuit.Cuit
import com.swelms.domain.person.FullName
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class Customer(
   var id: Int? = null,
   var fullName: FullName? = null,
   var birthDay: LocalDate? = null,
   var gender: Gender? = null,
   var cuit: Cuit? = null
)