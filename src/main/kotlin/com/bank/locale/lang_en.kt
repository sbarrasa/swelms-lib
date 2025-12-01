package com.bank.locale

import com.swelms.domain.person.Gender
import com.swelms.common.collections.Catalog
import com.swelms.common.locale.LangBuilder
import com.swelms.domain.id.card.CardNumber
import com.swelms.domain.id.cbu.CBU
import com.swelms.domain.id.cuit.Cuit
import com.swelms.domain.person.name.FullName
import com.swelms.domain.person.name.NamePart
import com.swelms.domain.validator.CheckDigitValidator

val lang_en = LangBuilder("en") {
   default {
      it["NO_CLASS_NAME"] = "Class must have simple name"
      it["TEST"] = "Test"
      it["NOT_IMPLEMENTED"] = "Not implemented yet"
      it["OUT_OF_RANGE"] = "The value must be between {1} and {2}"
      it["INVALID_LENGTH"] = "{0} must have {1} numeric digits"
      it["ONLY_DIGITS"] = "{0} can contain only numbers"
   }

   module<Cuit.EntityType> {
      it["PERSON"] = "individual"
      it["COMPANY"] = "company"
   }

   module<Cuit> {
      it["CUIT"] = "CUIT/CUIL"
      it["INVALID_ENTITY_CODE"] = "Invalid entity code"
   }

   module<CBU> {
      it["CBU"] = "CBU"
      it["BRANCH"] = "Branch"
      it["ACCOUNT"] = "Account number"
   }

   module<CardNumber> {
      it["CARD_NUMBER"] = "Card number"
   }

   module<NamePart> {
      it["INVALID_FORMAT"] = "Names can only contain letters, apostrophes and accents"
   }

   module<FullName> {
      it["INVALID_FORMAT"] = "Valid format is: 'Last Names, First Names'"
   }

   module<CheckDigitValidator> {
      it["INVALID_CHECK_DIGIT"] = "Invalid check digit for {0}"
   }

   module<Catalog> {
      it["NO_CLASS_NAME"] = "Class need a name"
   }

   module("CustomerService") {
      it["CUSTOMER_NOT_FOUND"] = "Customer not found"
      it["ID_CANT_BE_EMPTY"] = "Customer ID cannot be empty"
      it["INVALID_CUSTOMER_ID"] = "Invalid customer ID"
   }

   module<Gender> {
      it["M"] = "Male"
      it["F"] = "Female"
      it["X"] = "Undefine"
   }
}
