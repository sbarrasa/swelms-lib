package swelms.common.math

fun primes() = sequence {
   val primes = mutableListOf<Long>()
   var n = 2L

   while (true) {
      if (primes.none { n % it == 0L }) {
         primes.add(n)
         yield(n)
      }
      n++
   }
}