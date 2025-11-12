package com.bank.model.customer

import com.sbarrasa.fiscal.cuit.Cuit
import com.sbarrasa.util.id.Id
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class Customer(
   override var id: Int? = null,
   //TODO: pasar a Name()
   var name: String? = null,
   var lastName: String? = null,
   var birthDay: LocalDate? = null,
   var gender: Gender? = null,
   var cuit: Cuit? = null)
: Id<Int?>