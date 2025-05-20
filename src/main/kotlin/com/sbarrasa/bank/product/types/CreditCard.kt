package com.sbarrasa.bank.product.types

import com.sbarrasa.bank.product.factory.ProductRegister

class CreditCard: Card(CreditCard), CreditProduct {
    override var creditLimit: Double? = null
    var tier: String? = null

    override fun description() = "${super.description()} ${tier ?: ""}".trimEnd()

    companion object: ProductRegister<CreditCard> {
        override val productType = "TC"
        override val name = "Tarjeta de crédito"
        override val creator = ::CreditCard
    }
}