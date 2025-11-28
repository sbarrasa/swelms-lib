package com.swelms.domain.rate

import com.swelms.common.locale.*
import kotlin.math.round

class Rating(
   private var sum: Int = 0,
   private var count: Int = 0,
   private val range: IntRange = 1..10
) {
   fun add(value: Int) {
      require(value in range) { localeText("OUT_OF_RANGE").replaceSlots(range.first, range.last) }
      sum += value
      count++
   }

   fun averageRounded() = round(average()).toInt()

   fun average() = if (count > 0) sum.toDouble() / count else 0.0

   fun count() = count

   fun sum() = sum
}
