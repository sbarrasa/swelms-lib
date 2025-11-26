package com.bank.locale.lang.en

import com.bank.database.CustomerService
import com.swelms.common.locale.AbstractLangConfig
import com.swelms.domain.cuit.Cuit
import com.swelms.domain.cbu.CBU
import com.swelms.domain.card.CardNumber
import com.swelms.domain.validator.CheckDigitValidator
import com.swelms.common.collections.Catalog
import com.swelms.domain.person.FullName
import com.swelms.domain.person.NamePart


object LocaleConfig : AbstractLangConfig() {
   override fun register() {
      Any::class.register {
         it["NO_CLASS_NAME"] = "Class must have simple name"
         it["TEST"] = "Test"
         it["NOT_IMPLEMENTED"] = "Not implemented yet"
         it["OUT_OF_RANGE"] = "The value must be between {1} and {2}"
      }

      Cuit::class.register {
         it["PERSON_DESCRIPTION"] = "individual"
         it["COMPANY_DESCRIPTION"] = "company"
         it["CUIT_CUIL"] = "CUIT/CUIL"
         it["INVALID_LENGTH"] = "CUIT must have 11 numeric digits"
         it["ONLY_DIGITS"] = "CUIT can contain only numbers"
         it["INVALID_ENTITY_CODE"] = "Invalid entity code"
      }

      CBU::class.register {
         it["BRANCH"] = "Branch"
         it["ACCOUNT"] = "Account number"
         it["INVALID_LENGTH"] = "CBU must have 22 digits"
         it["ONLY_DIGITS"] = "CBU can contain only numbers"
      }

      CardNumber::class.register {
         it["CARD_NUMBER"] = "Card number"
         it["INVALID_LENGTH"] = "Card number length is invalid"
         it["ONLY_DIGITS"] = "Card number can contain only numbers"
      }

      NamePart::class.register {
         it["INVALID_FORMAT"] = "Names can only contain letters, apostrophes and accents"
      }

      FullName::class.register {
         it["INVALID_FORMAT"] = "Valid format is: 'Last Names, First Names'"
      }

      CheckDigitValidator::class.register {
         it["INVALID_CHECK_DIGIT"] = "Invalid check digit for"
      }

      Catalog::class.register {
         it["EMPTY_ITERABLE"] = "Cannot infer class from empty iterable"
      }

      CustomerService::class.register {
         it["CUSTOMER_NOT_FOUND"] = "Customer not found"
         it["ID_CANT_BE_EMPTY"] = "Customer ID cannot be empty"
         it["INVALID_CUSTOMER_ID"] = "Invalid customer ID"
      }


   }
}
