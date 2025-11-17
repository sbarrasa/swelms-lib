package com.bank.dto.products.structure

import com.sbarrasa.id.Desc

enum class Currency(override val description: String) : Desc {
   ARS("pesos"),
   USD("dólares"),
   EUR("euros")

}