package com.swelms.domain.cuit

object CuitEntityCodes : Map<String, CuitEntityCodes.Info> by mapOf(
   "20" to Info(Cuit.EntityType.PERSON, "Persona física (masculino)"),
   "23" to Info(Cuit.EntityType.PERSON, "Persona física (por duplicación)"),
   "24" to Info(Cuit.EntityType.PERSON, "Persona física (por duplicación)"),
   "25" to Info(Cuit.EntityType.PERSON, "Persona física (por duplicación)"),
   "26" to Info(Cuit.EntityType.PERSON, "Persona física (por duplicación)"),
   "27" to Info(Cuit.EntityType.PERSON, "Persona física (femenino)"),
   "30" to Info(Cuit.EntityType.COMPANY, "Persona jurídica"),
   "33" to Info(Cuit.EntityType.COMPANY, "Persona jurídica"),
   "34" to Info(Cuit.EntityType.COMPANY, "Persona jurídica")
) {

    data class Info(
       val entityType: Cuit.EntityType,
       val description: String
    ) {
       override fun toString() = description
    }
}