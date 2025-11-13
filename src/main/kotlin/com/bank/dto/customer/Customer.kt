package com.bank.dto.customer

import com.sbarrasa.fiscal.cuit.Cuit
import com.sbarrasa.person.Name
import com.sbarrasa.person.Nombrable
import com.sbarrasa.util.id.Id
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class Customer(
   override var id: Int? = null,
   var legalName: Name? = null,
   var birthDay: LocalDate? = null,
   var gender: Gender? = null,
   var cuit: Cuit? = null)
: Id<Int?>, Nombrable by legalName?: Name()