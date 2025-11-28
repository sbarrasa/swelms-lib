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

object LocaleConfig_es : AbstractLangConfig() {
   override val locale_id: String = "es"

   override fun onLoad() {
      defaults {
         it["NO_CLASS_NAME"] = "La clase debe tener un nombre simple"
         it["TEST"] = "Prueba"
         it["NOT_IMPLEMENTED"] = "Aún no está implementado"
         it["OUT_OF_RANGE"] = "El valor debe estar entre {1} y {2}"
         it["INVALID_LENGTH"] = "{0} debe tener {1} dígitos numéricos"
         it["ONLY_DIGITS"] = "{0} sólo puede contener dígitos numérico"
      }

      forClass<Cuit.EntityType>{
         it["PERSON_DESCRIPTION"] = "persona física"
         it["COMPANY_DESCRIPTION"] = "persona jurídica"
      }
      forClass<Cuit> {
         it["CUIT"] = "CUIT/CUIL"
         it["INVALID_ENTITY_CODE"] = "Código de entidad inválido"
      }

      forClass<CBU> {
         it["BRANCH"] = "Entidad/sucursal"
         it["ACCOUNT"] = "Número de cuenta"
      }

      forClass<CardNumber> {
         it["CARD_NUMBER"] = "Número de tarjeta"
         it["INVALID_LENGTH"] = "{0}: longitud inválida"
      }

      forClass<NamePart> {
         it["INVALID_FORMAT"] = "Los nombres sólo pueden incluir letras, apóstrofes y acentos"
      }

      forClass<FullName> {
         it["INVALID_FORMAT"] = "Formato valido debe ser 'Apellidos, Nombres' "
      }

      forClass<CheckDigitValidator> {
         it["INVALID_CHECK_DIGIT"] = "Dígito verificador inválido para {0}"
      }

      forClass<Catalog> {
         it["NO_CLASS_NAME"] = "La clase debe tener nombre"
      }

      forClass<CustomerService> {
         it["CUSTOMER_NOT_FOUND"] = "Cliente no encontrado"
         it["ID_CANT_BE_EMPTY"] = "Debe especificar un Customer.ID"
         it["INVALID_CUSTOMER_ID"] = "Customer.ID inválido"
      }

      forClass<Gender> {
         it["M"] = "Masculino"
         it["F"] = "Femenino"
         it["X"] = "Sin definición"
      }

   }
}