package swelms.common.math

fun factorial(value: Int): Long {
   if (value < 0) throw ArithmeticException("$value must be positive")
   if (value > 20) throw ArithmeticException("factorial of $value exceeds 64 bits")

   if (value == 0 || value == 1) return 1L

   return (2..value)
            .fold(1L) { acc, value -> acc * value }

}


val Int.factorial get() = factorial(this)