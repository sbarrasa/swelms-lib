package com.bank.model.products.structure

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
abstract class Card : Product() {
   abstract val branch: Branch
   abstract val number: String
   abstract val expirationDate: LocalDate

   override val id: String
      get() = number

   override val description: String
      get() =  "${descriptor?.description} ${branch.description}"

}