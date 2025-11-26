package com.swelms.domain.id.card

data class Bin(
   val range: IntRange,
   val brand: CardBrand,
   val cardNumberLength: Int
)