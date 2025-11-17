package com.bank.dto.products.structure

import com.sbarrasa.id.IdDesc
import kotlinx.serialization.Serializable

@Serializable
abstract class Product: IdDesc<String> {
   val isCredit get() = this is CreditProduct
}