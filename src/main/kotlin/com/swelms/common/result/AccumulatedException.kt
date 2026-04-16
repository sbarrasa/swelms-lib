package com.swelms.common.result

class AccumulatedException(
   val errors: List<Throwable>
) : Exception(errors.lastOrNull()?.message) {
   val last: Throwable?
      get() = errors.lastOrNull()
}
