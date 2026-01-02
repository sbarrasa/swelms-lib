package com.swelms.common.math

fun factorial(value: Int): Long {
      if (value < 0) throw ArithmeticException("Factorial no está definido para números negativos ($value)")
      if (value > 20) throw ArithmeticException("Desbordamiento $value supera los 64 bits")

      var result = 1L
      for(v in 2..value) { result *= v }
      return result
   }
