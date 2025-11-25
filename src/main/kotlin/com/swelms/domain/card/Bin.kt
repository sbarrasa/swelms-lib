package com.swelms.domain.card

data class Bin(
   val range: IntRange,
   val brand: CardBrand,
   val cardNumberLength: Int
)