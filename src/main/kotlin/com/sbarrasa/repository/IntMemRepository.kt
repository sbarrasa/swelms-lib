package com.sbarrasa.repository

import com.sbarrasa.id.Id

open class IntMemRepository<T : Id<Int?>> : MemRepository<Int?, T>(
   autoId = true,
   idGenerator = run {
      var nextId = 1
      { nextId++ }
   }
)
