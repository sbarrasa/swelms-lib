package com.bank.model.customer

import com.sbarrasa.util.id.Id
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class Customer (
    override var id: Int? = null,
    var name: String? = null,
    var lastName: String?= null,
    var birthDay: LocalDate? = null,
    var gender: Gender? = null
): Id<Int?>
