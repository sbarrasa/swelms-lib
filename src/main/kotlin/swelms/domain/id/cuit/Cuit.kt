package swelms.domain.id.cuit

import swelms.common.locale.*
import swelms.common.text.replaceSlots
import swelms.common.validator.ValidatorException
import swelms.domain.validator.DigitsValidator
import swelms.domain.validator.LengthValidator
import kotlinx.serialization.Serializable
import swelms.domain.id.componentName

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
      LengthValidator(localeText("INVALID_LENGTH").replaceSlots("CUIT", SIZE), SIZE).validate(value)
   }

   private fun validateDigits() {
      DigitsValidator(localeText("ONLY_DIGITS").replaceSlots("CUIT")).validate(value)
   }

   private fun validateEntityCode() {
      if (EntityCodes[entityCode] == null) throw ValidatorException(localeText("INVALID_ENTITY_CODE"))
   }

   private fun validateCheckDigit() {
      CuitCheckDigitValidator.validate(value)
   }

   companion object {
      const val SIZE = 11
   }

   fun formated() = "$entityCode-$document-$check"
   override fun toString(): String = value

   enum class EntityType {
      PERSON,
      COMPANY;

      val description: String
         get() = LocaleContext.current.text(componentName, name)
   }

   object EntityCodes :
      Set<EntityCodes.Info> by setOf(
         Info("20", EntityType.PERSON),
         Info("23", EntityType.PERSON),
         Info("24", EntityType.PERSON),
         Info("25", EntityType.PERSON),
         Info("26", EntityType.PERSON),
         Info("27", EntityType.PERSON),
         Info("30", EntityType.COMPANY),
         Info("33", EntityType.COMPANY),
         Info("34", EntityType.COMPANY)
      ) {

      class Info(val key: String, val entityType: EntityType) {
         val description: String
            get() = LocaleContext.current.textOrNull(componentName, key)
               ?: "$entityType.description".trim()

         override fun toString() = description
      }

      operator fun get(key: String) = find { it.key == key }

   }


}