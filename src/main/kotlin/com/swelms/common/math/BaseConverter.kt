package com.swelms.common.math

class BaseConverter(val base: Int) {

   init { require(base in 1..36) }

   private val digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"

   private fun convertPositive(n: Long): String {
      if (n == 0L) return "0"

      if (base==1) return "1".repeat(n.toInt())

      val sb = StringBuilder()
      var x = n
      while (x > 0) {
         sb.append(digits[(x % base).toInt()])
         x /= base
      }
      return sb.reverse().toString()
   }

   fun convert(value: Number): String {
      val n = value.toLong()
      return if (n < 0) "-" + convertPositive(-n) else convertPositive(n)
   }
}

fun Number.toBase(base: Int): String = BaseConverter(base).convert(this)
