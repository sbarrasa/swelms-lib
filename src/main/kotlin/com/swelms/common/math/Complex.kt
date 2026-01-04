package com.swelms.common.math

data class Complex(val real: Double, val imag: Double=0.0) {
   operator fun plus(other: Complex) = Complex(real + other.real, imag + other.imag)
   operator fun minus(other: Complex) = Complex(real - other.real, imag - other.imag)
   operator fun times(other: Complex) = Complex(real*other.real - imag*other.imag,
      real*other.imag + imag*other.real)
   operator fun div(other: Complex): Complex {
      val denom = other.real*other.real + other.imag*other.imag
      return Complex((real*other.real + imag*other.imag)/denom,
         (imag*other.real - real*other.imag)/denom)
   }

   fun toDouble() = real
   fun toInt() = real.toInt()

   companion object{
      val i = sqrt(-1.0)
      fun sqrt(x: Int) = if (x < 0) Complex(0.0, kotlin.math.sqrt(-x.toDouble())) else Complex(kotlin.math.sqrt(x.toDouble()), 0.0)
      fun sqrt(x: Double) = if (x < 0) Complex(0.0, kotlin.math.sqrt(-x)) else Complex(kotlin.math.sqrt(x), 0.0)
   }
}


