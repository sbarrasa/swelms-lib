package com.sbarrasa.repository

import com.sbarrasa.common.id.Id
import com.sbarrasa.common.id.generators.IdGen

//TODO: que la clave no sea por interface sino por función
open class MemRepository<I : Any, T : Id<I?>>(
   private val idGenerator: IdGen<I>? = null
) : Repository<I, T> {

   protected val items = mutableMapOf<I, T>()

   override fun getAll(): List<T> = items.values.toList()

   override fun get(id: I): T = items[id]
      ?: throw EntityNotFoundException(id = id)

   override fun add(dto: T): T {
      var id = dto.id
      if (idGenerator!=null)
         id = idGenerator.next()

      items[id!!] = dto
      return dto
   }

   override fun update(id: I, dto: T): T {
      items[id] = dto
      return dto
   }

   override fun delete(id: I): T {
      return items.remove(id)
         ?: throw EntityNotFoundException(id = id)
   }
}