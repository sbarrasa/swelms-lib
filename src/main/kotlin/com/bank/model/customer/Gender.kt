package com.bank.model.customer

import com.sbarrasa.util.id.Desc
import com.sbarrasa.util.id.EnumDescMap

enum class Gender(override val description: String) : Desc {
   M("masculino"),
   F("femenino"),
   X("indefinido");

   companion object : EnumDescMap<Gender> {
      override val values = entries
   }

}

