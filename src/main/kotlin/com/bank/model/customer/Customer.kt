package com.bank.model.customer

import com.sbarrasa.legal.cuit.Cuit
import com.sbarrasa.person.Name
import com.sbarrasa.id.Id
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