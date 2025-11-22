package com.bank.locale.lang.en

import com.sbarrasa.common.collections.Catalog
import com.sbarrasa.domain.card.CardNumber
import com.sbarrasa.domain.cbu.CBU
import com.sbarrasa.domain.cuit.Cuit
import com.sbarrasa.domain.person.NameUtils
import com.sbarrasa.domain.validator.CheckDigitValidator
import com.sbarrasa.repository.EntityNotFoundException

object LocalConfig {
   init {
      // Cuit
      Cuit.Texts.PERSON_DESCRIPTION = "individual"
      Cuit.Texts.COMPANY_DESCRIPTION = "company"
      Cuit.Texts.CUIT_CUIL = "CUIT/CUIL"
      Cuit.Texts.INVALID_LENGTH = "CUIT must have 11 numeric digits"
      Cuit.Texts.ONLY_DIGITS = "CUIT can contain only numbers"
      Cuit.Texts.INVALID_ENTITY_CODE = "Invalid entity code"

      // CBU
      CBU.Texts.BRANCH = "Branch"
      CBU.Texts.ACCOUNT = "Account number"
      CBU.Texts.INVALID_LENGTH = "CBU must have 22 digits"
      CBU.Texts.ONLY_DIGITS = "CBU can contain only numbers"

      // CardNumber
      CardNumber.Texts.CARD_NUMBER = "Card number"
      CardNumber.Texts.INVALID_LENGTH = "Card number length is invalid"
      CardNumber.Texts.ONLY_DIGITS = "Card number can contain only numbers"

      // NameUtils
      NameUtils.Texts.INVALID_FORMAT = "Names cannot contain special characters"

      // CheckDigitValidator
      CheckDigitValidator.Texts.INVALID_CHECK_DIGIT = "Invalid check digit for"

      // Catalog
      Catalog.Texts.NO_CLASS_NAME = "Class must have simple name"
      Catalog.Texts.EMPTY_ITERABLE = "Cannot infer class from empty iterable"

      EntityNotFoundException.Texts.ENTITY_NOT_FOUND = "Entity not found"

   }
}
