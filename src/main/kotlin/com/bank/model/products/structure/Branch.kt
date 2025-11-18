package com.bank.model.products.structure

import com.sbarrasa.id.Desc

enum class Branch(override val description: String) : Desc {
   VISA("VISA"),
   MC("MasterCard"),
   AMEX("American Express");
}