package com.bank.dto.product

import com.sbarrasa.util.id.Desc

enum class Currency(override val description: String) : Desc {
   ARS("pesos"),
   USD("dólares"),
   EUR("euros")

}
