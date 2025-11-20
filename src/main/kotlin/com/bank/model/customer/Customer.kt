package com.bank.model.customer

import com.sbarrasa.domain.cuit.Cuit
import com.sbarrasa.common.id.Id
import com.sbarrasa.domain.person.FullName
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class Customer(
   override var id: Int? = null,
   var fullName: FullName? = null,
   var birthDay: LocalDate? = null,
   var gender: Gender? = null,
   var cuit: Cuit? = null)
: Id<Int?>