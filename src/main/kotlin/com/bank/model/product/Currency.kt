package com.bank.model.product

import com.sbarrasa.util.id.Desc
import com.sbarrasa.util.id.EnumDescMap

enum class Currency(override val description: String): Desc {
    ARS("pesos"),
    USD("dólares"),
    EUR("euros");
    companion object: EnumDescMap<Currency> {
        override val values = entries
    }
}
