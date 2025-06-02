package com.bank.model.product

import com.sbarrasa.util.id.Desc
import com.sbarrasa.util.id.EnumDescMap

enum class Branch(override val description: String) : Desc {
   VISA("VISA"),
   MC("MasterCard"),
   AMEX("American Express");

   companion object : EnumDescMap<Branch> {
      override val values = entries
   }
}
