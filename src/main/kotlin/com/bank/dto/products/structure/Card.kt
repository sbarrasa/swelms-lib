package com.bank.dto.products.structure

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
abstract class Card : Product() {
   abstract val branch: Branch
   abstract val number: String
   abstract val expirationDate: LocalDate

   override fun fullDescription() = "${descriptor.description} ${branch.description}"
}