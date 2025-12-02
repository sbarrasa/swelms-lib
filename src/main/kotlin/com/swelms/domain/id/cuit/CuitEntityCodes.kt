package com.swelms.domain.id.cuit

import com.swelms.common.collections.Mappeable
import com.swelms.common.locale.Locale
import com.swelms.common.reflection.qName

object CuitEntityCodes :
   Mappeable<String, String>,
   Set<CuitEntityCodes.Info> by setOf(
      Info("20", Cuit.EntityType.PERSON),
      Info("23", Cuit.EntityType.PERSON),
      Info("24", Cuit.EntityType.PERSON),
      Info("25", Cuit.EntityType.PERSON),
      Info("26", Cuit.EntityType.PERSON),
      Info("27", Cuit.EntityType.PERSON),
      Info("30", Cuit.EntityType.COMPANY),
      Info("33", Cuit.EntityType.COMPANY),
      Info("34", Cuit.EntityType.COMPANY)
) {
   class Info(val key: String, val entityType: Cuit.EntityType) {
      val moreInfo: String
         get() = Locale.textOrNull(CuitEntityCodes::class.qName, key)
            ?: ""

      val description: String
         get() = "${entityType.description} $moreInfo".trim()

      override fun toString() = description
   }

   operator fun get(key: String) = find { it.key == key }
   override fun asMap(): Map<String, String> = associate { it.key to it.description }
}
