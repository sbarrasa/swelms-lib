package com.swelms.common.math

fun gcd(a: Int, b: Int): Int {
   var x = kotlin.math.abs(a)
   var y = kotlin.math.abs(b)

   while (y != 0) {
      val t = x % y
      x = y
      y = t
   }

   return x
}

fun lcm(a: Int, b: Int) = kotlin.math.abs(a / gcd(a, b) * b)


