package com.bank.dto.product.types

import com.bank.dto.product.Branch
import com.bank.dto.product.Product
import com.bank.dto.product.ProductHeader
import java.time.LocalDate

abstract class Card(header: ProductHeader) : Product(header) {
   var branch: Branch? = null
   var number: String? = null
   var expirationDate: LocalDate? = null
   override fun fullDescription() = "$description ${branch?.description}"
}