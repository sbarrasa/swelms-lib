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
import com.swelms.domain.locale.Currency

object LocaleConfig_es : AbstractLangConfig {
   override val locale_id = "es"

   override val textsByModule = mapOf(
      Locale.DEFAULT to mutableMapOf(
         "NO_CLASS_NAME"   to "La clase debe tener un nombre simple",
         "TEST"            to "Prueba",
         "NOT_IMPLEMENTED" to "Aún no está implementado",
         "OUT_OF_RANGE"    to "El valor debe estar entre {1} y {2}",
         "INVALID_LENGTH"  to "{0} debe tener {1} dígitos numéricos",
         "ONLY_DIGITS"     to "{0} sólo puede contener dígitos numérico"
      ),

      Cuit.EntityType::class.qName to mutableMapOf(
         "PERSON_DESCRIPTION"  to "persona física",
         "COMPANY_DESCRIPTION" to "persona jurídica"
      ),

      Cuit::class.qName to mutableMapOf(
         "CUIT"                to "CUIT/CUIL",
         "INVALID_ENTITY_CODE" to "Código de entidad inválido"
      ),

      CBU::class.qName to mutableMapOf(
         "BRANCH"  to "Entidad/sucursal",
         "ACCOUNT" to "Número de cuenta"
      ),

      CardNumber::class.qName to mutableMapOf(
         "CARD_NUMBER"    to "Número de tarjeta",
         "INVALID_LENGTH" to "{0}: longitud inválida"
      ),

      NamePart::class.qName to mutableMapOf(
         "INVALID_FORMAT" to "Los nombres sólo pueden incluir letras, apóstrofes y acentos"
      ),

      FullName::class.qName to mutableMapOf(
         "INVALID_FORMAT" to "Formato valido debe ser 'Apellidos, Nombres'"
      ),

      CheckDigitValidator::class.qName to mutableMapOf(
         "INVALID_CHECK_DIGIT" to "Dígito verificador inválido para {0}"
      ),

      Catalog::class.qName to mutableMapOf(
         "NO_CLASS_NAME" to "La clase debe tener nombre"
      ),

      CustomerService::class.qName to mutableMapOf(
         "CUSTOMER_NOT_FOUND"  to "Cliente no encontrado",
         "ID_CANT_BE_EMPTY"    to "Debe especificar un Customer.ID",
         "INVALID_CUSTOMER_ID" to "Customer.ID inválido"
      ),

      Gender::class.qName to mutableMapOf(
         "M" to "Masculino",
         "F" to "Femenino",
         "X" to "Sin definición"
      ),

      Currency::class.qName to mutableMapOf(
         Currency.ARS.name to "pesos argentinos",
         Currency.USD.name to "dolares estadounidenses",
         Currency.EUR.name to "euros",
         Currency.BRL.name to "real brazilero"
      )
   )
}
