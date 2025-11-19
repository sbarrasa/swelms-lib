package com.bank.model.customer

import com.sbarrasa.domain.cuit.Cuit
import com.sbarrasa.domain.person.Name
import com.sbarrasa.common.id.Id
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class Customer(
   override var id: Int? = null,
   var legalName: Name? = null,
   var birthDay: LocalDate? = null,
   var gender: Gender? = null,
   var cuit: Cuit? = null)
: Id<Int?>