package com.bank.locale

import com.bank.database.CustomerService
import com.swelms.domain.person.Gender
import com.swelms.common.collections.Catalog
import com.swelms.common.locale.LangBuilder
import com.swelms.domain.id.card.CardNumber
import com.swelms.domain.id.cbu.CBU
import com.swelms.domain.id.cuit.Cuit
import com.swelms.domain.person.name.FullName
import com.swelms.domain.person.name.NamePart
import com.swelms.domain.validator.CheckDigitValidator
import com.swelms.domain.locale.Currency

val lang_es = LangBuilder("es") {
   default {
      it["NO_CLASS_NAME"] = "La clase debe tener un nombre simple"
      it["TEST"] = "Prueba"
      it["NOT_IMPLEMENTED"] = "Aún no está implementado"
      it["OUT_OF_RANGE"] = "El valor debe estar entre {1} y {2}"
      it["INVALID_LENGTH"] = "{0} debe tener {1} dígitos numéricos"
      it["ONLY_DIGITS"] = "{0} sólo puede contener dígitos numérico"
   }

   module<Cuit.EntityType> {
      it["PERSON_DESCRIPTION"] = "persona física"
      it["COMPANY_DESCRIPTION"] = "persona jurídica"
   }

   module<Cuit> {
      it["CUIT"] = "CUIT/CUIL"
      it["INVALID_ENTITY_CODE"] = "Código de entidad inválido"
   }

   module<CBU> {
      it["BRANCH"] = "Entidad/sucursal"
      it["ACCOUNT"] = "Número de cuenta"
   }

   module<CardNumber> {
      it["CARD_NUMBER"] = "Número de tarjeta"
      it["INVALID_LENGTH"] = "{0}: longitud inválida"
   }

   module<NamePart> {
      it["INVALID_FORMAT"] = "Los nombres sólo pueden incluir letras, apóstrofes y acentos"
   }

   module<FullName> {
      it["INVALID_FORMAT"] = "Formato valido debe ser 'Apellidos, Nombres'"
   }

   module<CheckDigitValidator> {
      it["INVALID_CHECK_DIGIT"] = "Dígito verificador inválido para {0}"
   }

   module<Catalog> {
      it["NO_CLASS_NAME"] = "La clase debe tener nombre"
   }

   module<CustomerService> {
      it["CUSTOMER_NOT_FOUND"] = "Cliente {1} no encontrado"
      it["ID_CANT_BE_EMPTY"] = "Debe especificar un Customer ID"
      it["INVALID_CUSTOMER_ID"] = "Customer ID inválido: {1}"
   }

   module<Gender> {
      it[Gender.M.name] = "Masculino"
      it[Gender.F.name] = "Femenino"
      it[Gender.X.name] = "Sin definición"
   }

   module<Currency> {
      it[Currency.ARS.name] = "pesos argentinos"
      it[Currency.USD.name] = "dólares estadounidenses"
      it[Currency.EUR.name] = "euros"
      it[Currency.BRL.name] = "real brasileño"
   }
}

