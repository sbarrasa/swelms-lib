package com.sbarrasa.bank.product.types

import com.sbarrasa.bank.product.factory.ProductRegister

class DebitCard: Card(DebitCard) {
    companion object: ProductRegister<DebitCard> {
        override val productType = "TD"
        override val name = "Tarjeta de débito"
        override val creator = ::DebitCard
    }
}