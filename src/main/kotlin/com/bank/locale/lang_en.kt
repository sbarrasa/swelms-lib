package com.bank.locale

import com.bank.model.products.structure.Product
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
   defaults {
      key["NO_CLASS_NAME"] = "Class must have simple name"
      key["TEST"] = "Test"
      key["NOT_IMPLEMENTED"] = "Not implemented yet"
      key["OUT_OF_RANGE"] = "The value must be between {1} and {2}"
      key["INVALID_LENGTH"] = "{0} must have {1} numeric digits"
      key["ONLY_DIGITS"] = "{0} can contain only numbers"
   }

   module<Cuit.EntityType> {
      key["PERSON"] = "individual"
      key["COMPANY"] = "company"
   }

   module<Cuit> {
      key["CUIT"] = "CUIT/CUIL"
      key["INVALID_ENTITY_CODE"] = "Invalid entity code"
   }

   module<CBU> {
      key["CBU"] = "CBU"
      key["BRANCH"] = "Branch"
      key["ACCOUNT"] = "Account number"
   }

   module<CardNumber> {
      key["CARD_NUMBER"] = "Card number"
   }

   module<NamePart> {
      key["INVALID_FORMAT"] = "Names can only contain letters, apostrophes and accents"
   }

   module<FullName> {
      key["INVALID_FORMAT"] = "Valid format is: 'Last Names, First Names'"
   }

   module<CheckDigitValidator> {
      key["INVALID_CHECK_DIGIT"] = "Invalid check digit for {0}"
   }

   module<Catalog> {
      key["NO_CLASS_NAME"] = "Class need a name"
   }

   module("CustomerService") {
      key["CUSTOMER_NOT_FOUND"] = "Customer not found"
      key["ID_CANT_BE_EMPTY"] = "Customer ID cannot be empty"
      key["INVALID_CUSTOMER_ID"] = "Invalid customer ID"
   }

   module<Gender> {
      key["M"] = "Male"
      key["F"] = "Female"
      key["X"] = "Undefine"
   }

   module(Product.MODULE){
      key["TD"] = "Debit card"
      key["TC"] = "Credit card"
      key["CC"] = "Checking account"
      key["CA"] = "Saving account"
   }
}
