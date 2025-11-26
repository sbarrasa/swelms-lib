package com.swelms.domain.id.card

object BinTable{
   val bins = listOf(
      Bin(4..4, CardBrand.VISA, 16),
      Bin(51..55, CardBrand.MC, 16),
      Bin(2221..2720, CardBrand.MC, 16),
      Bin(50..50, CardBrand.MAESTRO, 18),
      Bin(34..34, CardBrand.AMEX, 15),
      Bin(37..37, CardBrand.AMEX, 15),
      Bin(60..60, CardBrand.DISCOVER, 16),
      Bin(644..650, CardBrand.DISCOVER, 16),
      Bin(300..305, CardBrand.DINERS, 14),
      Bin(36..36, CardBrand.DINERS, 14),
      Bin(38..39, CardBrand.DINERS, 14),
      Bin(6042..6042, CardBrand.CABAL, 16)
   )

   fun get(cardNumber: String): Bin? {
      val binsByLength = groupByBinLength()

      for (len in binsByLength.keys.sortedDescending()) {
         if (cardNumber.length < len) continue
         val prefix = cardNumber.take(len).toIntOrNull() ?: continue
         binsByLength[len]?.firstOrNull { prefix in it.range }?.let { return it }
      }

      return null
   }

   fun groupByBinLength(): Map<Int, List<Bin>> =
      bins.groupBy { it.range.last.toString().length }

   fun lengthRange(): IntRange {
      val lengths = bins.map { it.cardNumberLength }
      return lengths.min()..lengths.max()
   }

}

