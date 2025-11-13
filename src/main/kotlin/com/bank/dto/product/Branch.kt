package com.bank.dto.product

import com.sbarrasa.util.id.Desc


enum class Branch(override val description: String) : Desc {
   VISA("VISA"),
   MC("MasterCard"),
   AMEX("American Express");
}
