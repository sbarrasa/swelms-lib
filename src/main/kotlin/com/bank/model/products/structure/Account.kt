package com.bank.model.products.structure

import com.sbarrasa.legal.cbu.CBU
import kotlinx.serialization.Serializable

@Serializable
abstract class Account: Product() {
   abstract val cbu: CBU
   abstract val currency: Currency

   override val id: String
      get() = cbu.toString()

   override val description: String
      get() = "${descriptor?.description} en ${currency.description}"

}