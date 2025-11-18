package com.sbarrasa.legal.cuit

import com.sbarrasa.legal.LegalException

object CuitEntityCodes : Map<String, CuitEntityCodes.Info> by mapOf(
   "20" to Info(LegalEntity.FISICA, "Persona física (masculino)"),
   "23" to Info(LegalEntity.FISICA, "Persona física (prefijo alternativo por duplicación)"),
   "24" to Info(LegalEntity.FISICA, "Persona física (prefijo alternativo por duplicación)"),
   "25" to Info(LegalEntity.FISICA, "Persona física (prefijo alternativo por duplicación)"),
   "26" to Info(LegalEntity.FISICA, "Persona física (prefijo alternativo por duplicación)"),
   "27" to Info(LegalEntity.FISICA, "Persona física (femenino)"),
   "30" to Info(LegalEntity.JURIDICA, "Persona jurídica (empresa o sociedad)"),
   "33" to Info(LegalEntity.JURIDICA, "Persona jurídica (empresa o sociedad)"),
   "34" to Info(LegalEntity.JURIDICA, "Persona jurídica (empresa o sociedad)")
) {

   fun validate(entityCode: String?){
      if(entityCode == null)
         throw LegalException("debe especificar un código de entidad")

      if(this[entityCode] == null)
         throw LegalException("$entityCode no es un código de entidad válido")
   }
   class Info(
      val legalEntity: LegalEntity,
      val description: String
   )
}