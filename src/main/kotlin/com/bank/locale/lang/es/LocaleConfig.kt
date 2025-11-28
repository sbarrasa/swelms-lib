package com.bank.locale.lang.es

import com.bank.database.CustomerService
import com.bank.model.customer.Gender
import com.swelms.common.locale.AbstractLangConfig
import com.swelms.domain.id.cuit.Cuit
import com.swelms.domain.id.cbu.CBU
import com.swelms.domain.id.card.CardNumber
import com.swelms.domain.validator.CheckDigitValidator
import com.swelms.common.collections.Catalog
import com.swelms.domain.person.FullName
import com.swelms.domain.person.NamePart

object LocaleConfig : AbstractLangConfig() {
   override fun register() {
      defaults {
         it["NO_CLASS_NAME"] = "La clase debe tener un nombre simple"
         it["TEST"] = "Prueba"
         it["NOT_IMPLEMENTED"] = "Aún no está implementado"
         it["OUT_OF_RANGE"] = "El valor debe estar entre {1} y {2}"
      }

      texts<Cuit.EntityType>{
         it["PERSON_DESCRIPTION"] = "persona física"
         it["COMPANY_DESCRIPTION"] = "persona jurídica"
      }
      texts<Cuit> {
         it["CUIT_CUIL"] = "CUIT/CUIL"
         it["INVALID_LENGTH"] = "CUIT debe tener 11 dígitos numéricos"
         it["ONLY_DIGITS"] = "CUIT solo puede contener números"
         it["INVALID_ENTITY_CODE"] = "Código de entidad inválido"
      }

      texts<CBU> {
         it["BRANCH"] = "Entidad/sucursal"
         it["ACCOUNT"] = "Número de cuenta"
         it["INVALID_LENGTH"] = "CBU debe tener 22 dígitos"
         it["ONLY_DIGITS"] = "CBU solo puede contener números"
      }

      texts<CardNumber> {
         it["CARD_NUMBER"] = "Número de tarjeta"
         it["INVALID_LENGTH"] = "Longitud del número de tarjeta inválida"
         it["ONLY_DIGITS"] = "El número de tarjeta solo puede contener números"
      }

      texts<NamePart> {
         it["INVALID_FORMAT"] = "Los nombres sólo pueden incluir letras, apóstrofes y acentos"
      }

      texts<FullName> {
         it["INVALID_FORMAT"] = "Formato valido debe ser 'Apellidos, Nombres' "
      }

      texts<CheckDigitValidator> {
         it["INVALID_CHECK_DIGIT"] = "Dígito verificador inválido para"
      }

      texts<Catalog> {
         it["NO_CLASS_NAME"] = "La clase debe tener nombre simple"
         it["EMPTY_ITERABLE"] = "No se puede inferir la clase de un iterable vacío"
      }

      texts<CustomerService> {
         it["CUSTOMER_NOT_FOUND"] = "Cliente no encontrado"
         it["ID_CANT_BE_EMPTY"] = "Debe especificar un Customer.ID"
         it["INVALID_CUSTOMER_ID"] = "Customer.ID inválido"
      }

      texts<Gender> {
         it["M_DESCRIPTION"] = "Masculino"
         it["F_DESCRIPTION"] = "Femenino"
         it["X_DESCRIPTION"] = "Sin definición"
      }

   }
}
