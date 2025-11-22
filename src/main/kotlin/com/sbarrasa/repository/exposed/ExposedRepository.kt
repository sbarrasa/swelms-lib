package com.sbarrasa.repository.exposed

import com.sbarrasa.repository.EntityNotFoundException
import com.sbarrasa.repository.Repository
import com.sbarrasa.common.id.Id
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.sql.transactions.transaction

abstract class ExposedRepository<T : Id<Int?>, E : IntEntity>(
   val entityClass: EntityClass<Int, E>) : Repository<Int, T> {

   protected abstract fun mapToDTO(entity: E): T
   protected abstract fun mapToEntity(dto: T, entity: E)

   override fun getAll(): List<T> = transaction {
      return@transaction entityClass.all().map { mapToDTO(it) }
   }

   override fun get(id: Int): T = transaction {
      val entity = find(id)
      return@transaction mapToDTO(entity)
   }

   override fun add(dto: T): T = transaction {
      val created = entityClass.new { }
      mapToEntity(dto, created)
      return@transaction mapToDTO(created)
   }

   override fun update(id: Int, dto: T): T = transaction {
      val current = find(id)
      mapToEntity(dto, current)
      return@transaction mapToDTO(current)
   }

   override fun delete(id: Int): T = transaction {
      val entity = find(id)
      val dto = mapToDTO(entity)
      entity.delete()
      return@transaction dto
   }

   fun find(id: Int): E {
      return entityClass.findById(id) ?: throw EntityNotFoundException()
   }
}