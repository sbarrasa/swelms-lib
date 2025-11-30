package com.bank.locale

import com.bank.database.CustomerService
import com.swelms.domain.person.Gender
import com.swelms.common.collections.Catalog
import com.swelms.common.locale.AbstractLangConfig
import com.swelms.common.locale.Locale
import com.swelms.domain.id.card.CardNumber
import com.swelms.domain.id.cbu.CBU
import com.swelms.domain.id.cuit.Cuit
import com.swelms.domain.name.FullName
import com.swelms.domain.name.NamePart
import com.swelms.domain.validator.CheckDigitValidator
import com.swelms.common.reflection.qName

object LocaleConfig_en : AbstractLangConfig {
   override val locale_id = "en"

   override val textsByModule = mapOf(
      Locale.DEFAULT to mutableMapOf(
         "NO_CLASS_NAME"   to "Class must have simple name",
         "TEST"            to "Test",
         "NOT_IMPLEMENTED" to "Not implemented yet",
         "OUT_OF_RANGE"    to "The value must be between {1} and {2}",
         "INVALID_LENGTH"  to "{0} must have {1} numeric digits",
         "ONLY_DIGITS"     to "{0} can contain only numbers"
      ),

      Cuit.EntityType::class.qName to mutableMapOf(
         "PERSON"  to "individual",
         "COMPANY" to "company"
      ),

      Cuit::class.qName to mutableMapOf(
         "CUIT"                to "CUIT/CUIL",
         "INVALID_ENTITY_CODE" to "Invalid entity code"
      ),

      CBU::class.qName to mutableMapOf(
         "CBU"    to "CBU",
         "BRANCH" to "Branch",
         "ACCOUNT" to "Account number"
      ),

      CardNumber::class.qName to mutableMapOf(
         "CARD_NUMBER" to "Card number"
      ),

      NamePart::class.qName to mutableMapOf(
         "INVALID_FORMAT" to "Names can only contain letters, apostrophes and accents"
      ),

      FullName::class.qName to mutableMapOf(
         "INVALID_FORMAT" to "Valid format is: 'Last Names, First Names'"
      ),

      CheckDigitValidator::class.qName to mutableMapOf(
         "INVALID_CHECK_DIGIT" to "Invalid check digit for {0}"
      ),

      Catalog::class.qName to mutableMapOf(
         "NO_CLASS_NAME" to "Class need a name"
      ),

      CustomerService::class.qName to mutableMapOf(
         "CUSTOMER_NOT_FOUND"  to "Customer not found",
         "ID_CANT_BE_EMPTY"    to "Customer ID cannot be empty",
         "INVALID_CUSTOMER_ID" to "Invalid customer ID"
      ),

      Gender::class.qName to mutableMapOf(
         "M" to "Male",
         "F" to "Female",
         "X" to "Undefine"
      )
   )
}
