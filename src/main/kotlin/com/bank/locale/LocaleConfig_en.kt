package com.bank.locale

import com.bank.database.CustomerService
import com.bank.model.customer.Gender
import com.swelms.common.collections.Catalog
import com.swelms.common.locale.AbstractLangConfig
import com.swelms.domain.id.card.CardNumber
import com.swelms.domain.id.cbu.CBU
import com.swelms.domain.id.cuit.Cuit
import com.swelms.domain.person.FullName
import com.swelms.domain.person.NamePart
import com.swelms.domain.validator.CheckDigitValidator

object LocaleConfig_en : AbstractLangConfig() {
   override val key: String = "en"

   override fun onLoad() {
      defaults {
         it["NO_CLASS_NAME"] = "Class must have simple name"
         it["TEST"] = "Test"
         it["NOT_IMPLEMENTED"] = "Not implemented yet"
         it["OUT_OF_RANGE"] = "The value must be between {1} and {2}"
      }

      forClass<Cuit.EntityType> {
         it["PERSON_DESCRIPTION"] = "individual"
         it["COMPANY_DESCRIPTION"] = "company"
      }

      forClass<Cuit> {
         it["CUIT_CUIL"] = "CUIT/CUIL"
         it["INVALID_LENGTH"] = "CUIT must have 11 numeric digits"
         it["ONLY_DIGITS"] = "CUIT can contain only numbers"
         it["INVALID_ENTITY_CODE"] = "Invalid entity code"
      }

      forClass<CBU> {
         it["BRANCH"] = "Branch"
         it["ACCOUNT"] = "Account number"
         it["INVALID_LENGTH"] = "CBU must have 22 digits"
         it["ONLY_DIGITS"] = "CBU can contain only numbers"
      }

      forClass<CardNumber> {
         it["CARD_NUMBER"] = "Card number"
         it["INVALID_LENGTH"] = "Card number length is invalid"
         it["ONLY_DIGITS"] = "Card number can contain only numbers"
      }

      forClass<NamePart> {
         it["INVALID_FORMAT"] = "Names can only contain letters, apostrophes and accents"
      }

      forClass<FullName> {
         it["INVALID_FORMAT"] = "Valid format is: 'Last Names, First Names'"
      }

      forClass<CheckDigitValidator> {
         it["INVALID_CHECK_DIGIT"] = "Invalid check digit for"
      }

      forClass<Catalog> {
         it["EMPTY_ITERABLE"] = "Cannot infer class from empty iterable"
      }

      forClass<CustomerService> {
         it["CUSTOMER_NOT_FOUND"] = "Customer not found"
         it["ID_CANT_BE_EMPTY"] = "Customer ID cannot be empty"
         it["INVALID_CUSTOMER_ID"] = "Invalid customer ID"
      }

      forClass<Gender> {
         it["M_DESCRIPTION"] = "Male"
         it["F_DESCRIPTION"] = "Female"
         it["X_DESCRIPTION"] = "Undefine"
      }

   }
}