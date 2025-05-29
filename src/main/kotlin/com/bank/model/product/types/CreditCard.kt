package com.bank.model.product.types

import com.bank.model.product.factory.ProductRegister

class CreditCard: Card(CreditCard), CreditProduct {
    override var creditLimit: Double? = null
    var tier: String? = null

    override fun fullDescription() = "${super.fullDescription()} ${tier ?: ""}".trimEnd()

    companion object: ProductRegister<CreditCard> {
        override var id = "TC"
        override val description = "Tarjeta de crédito"
        override val creator = ::CreditCard
    }
}