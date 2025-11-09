package com.sbarrasa.cuit

import com.sbarrasa.id.IdDescMap
import kotlinx.serialization.Serializable


object EntityCodeMap : IdDescMap,  Map<String, EntityCodeMap.Data> by mapOf(
   "20" to Data(EntityType.FISICA, "Persona física (masculino)"),
   "23" to Data(EntityType.FISICA, "Persona física (prefijo alternativo por duplicación)"),
   "24" to Data(EntityType.FISICA, "Persona física (prefijo alternativo por duplicación)"),
   "25" to Data(EntityType.FISICA, "Persona física (prefijo alternativo por duplicación)"),
   "26" to Data(EntityType.FISICA, "Persona física (prefijo alternativo por duplicación)"),
   "27" to Data(EntityType.FISICA, "Persona física (femenino)"),
   "30" to Data(EntityType.JURIDICA, "Persona jurídica (empresa o sociedad)"),
   "33" to Data(EntityType.JURIDICA, "Persona jurídica (empresa o sociedad)"),
   "34" to Data(EntityType.JURIDICA, "Persona jurídica (empresa o sociedad)")
) {

   fun validate(entityCode: String?){
      if(entityCode == null)
         throw FiscalException("debe especificar un código de entidad")

      if(this[entityCode] == null)
         throw FiscalException("$entityCode es un código de entidad inválido")
   }
   @Serializable
   data class Data(
      val entityType: EntityType,
      val description: String
   )
   override fun asMap() = this.mapValues { it.value.description }

}