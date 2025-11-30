package com.bank.model.customer

import com.swelms.domain.id.cuit.Cuit
import com.swelms.domain.person.*
import com.swelms.domain.name.FullName
import com.swelms.domain.name.FullNameSerializer
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