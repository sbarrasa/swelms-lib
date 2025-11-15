package com.sbarrasa.repository

import com.sbarrasa.util.id.Id

open class IntMemRepository<T : Id<Int?>> : MemRepository<Int?, T>(
   idGenerator = run {
      var nextId = 1
      { nextId++ }
   }
)
