package com.bank.locale.lang.en

import com.bank.database.CustomerService
import com.sbarrasa.common.locale.AbstractLocaleConfig
import com.sbarrasa.domain.cuit.Cuit
import com.sbarrasa.domain.cbu.CBU
import com.sbarrasa.domain.card.CardNumber
import com.sbarrasa.domain.person.NameUtils
import com.sbarrasa.domain.validator.CheckDigitValidator
import com.sbarrasa.common.collections.Catalog


object LocaleConfig : AbstractLocaleConfig() {
   override fun register() {
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

      NameUtils::class.register {
         it["INVALID_FORMAT"] = "Invalid name"
      }

      CheckDigitValidator::class.register {
         it["INVALID_CHECK_DIGIT"] = "Invalid check digit for"
      }

      Catalog::class.register {
         it["NO_CLASS_NAME"] = "Class must have simple name"
         it["EMPTY_ITERABLE"] = "Cannot infer class from empty iterable"
      }

      CustomerService::class.register {
         it["CUSTOMER_NOT_FOUND"] = "Customer not found"
         it["ID_CANT_BE_EMPTY"] = "Customer ID cannot be empty"
         it["INVALID_CUSTOMER_ID"] = "Invalid customer ID"
      }

   }
}
