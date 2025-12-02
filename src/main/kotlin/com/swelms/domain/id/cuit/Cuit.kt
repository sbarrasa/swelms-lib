package com.swelms.domain.id.cuit

import com.swelms.common.collections.Mappeable
import com.swelms.common.locale.*
import com.swelms.common.reflection.qName
import com.swelms.domain.validator.ValidatorException
import com.swelms.domain.validator.DigitsValidator
import com.swelms.domain.validator.LengthValidator
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class Cuit(val value: String) {

   val entityCode: String get() = value.substring(0, 2)
   val document: String get() = value.substring(2, 10)
   val check: Char get() = value.substring(10, 11)[0]

   val entityType: EntityType get() = EntityCodes[entityCode]!!.entityType

   init {
      validateLength()
      validateDigits()
      validateEntityCode()
      validateCheckDigit()
   }

   private fun validateLength() {
      LengthValidator(localeText("INVALID_LENGTH").replaceSlots(LOCALE_CLASS_NAME, SIZE), SIZE).validate(value)
   }

   private fun validateDigits() {
      DigitsValidator(localeText("ONLY_DIGITS").replaceSlots(LOCALE_CLASS_NAME)).validate(value)
   }

   private fun validateEntityCode() {
      if (EntityCodes[entityCode] == null) throw ValidatorException(localeText("INVALID_ENTITY_CODE"))
   }

   private fun validateCheckDigit() {
      CuitCheckDigitValidator.validate(value)
   }

   companion object {
      const val SIZE = 11
      val LOCALE_CLASS_NAME = Locale.text(Cuit::class.qName, "CUIT")
   }

   fun formated() = "$entityCode-$document-$check"
   override fun toString(): String = value

   enum class EntityType {
      PERSON,
      COMPANY;

      val description: String
         get() = Locale.text(qName, name)
   }

   object EntityCodes :
      Mappeable<String, String>,
      Set<EntityCodes.Info> by setOf(
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
         val description: String
            get() = Locale.textOrNull(EntityCodes::class.qName, key)
               ?: "${entityType.description}".trim()

         override fun toString() = description
      }

      operator fun get(key: String) = find { it.key == key }
      override fun asMap(): Map<String, String> = associate { it.key to it.description }
   }


}