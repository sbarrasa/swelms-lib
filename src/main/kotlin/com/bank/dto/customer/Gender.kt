package com.bank.dto.customer

import com.sbarrasa.util.id.Desc


enum class Gender(override val description: String) : Desc {
   M("masculino"),
   F("femenino"),
   X("indefinido");
}

