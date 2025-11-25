package com.bank.model.customer

import com.swelms.domain.cuit.Cuit
import com.swelms.domain.person.FullName
import com.swelms.domain.person.FullNameSerializer
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class Customer(
   var id: Int? = null,
   @Serializable(with = FullNameSerializer::class)
   var fullName: FullName? = null,
   var birthDay: LocalDate? = null,
   var gender: Gender? = null,
   var cuit: Cuit? = null
)