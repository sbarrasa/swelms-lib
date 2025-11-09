package com.bank.model.customer

import com.sbarrasa.id.Desc


enum class Gender(override val description: String) : Desc {
   M("masculino"),
   F("femenino"),
   X("indefinido");
}

