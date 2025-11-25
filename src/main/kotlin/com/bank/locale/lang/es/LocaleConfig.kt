package com.bank.locale.lang.es

import com.bank.database.CustomerService
import com.swelms.common.locale.AbstractLangConfig
import com.swelms.domain.cuit.Cuit
import com.swelms.domain.cbu.CBU
import com.swelms.domain.card.CardNumber
import com.swelms.domain.person.NameUtils
import com.swelms.domain.validator.CheckDigitValidator
import com.swelms.common.collections.Catalog

object LocaleConfig : AbstractLangConfig() {
   override fun register() {
      Cuit::class.register {
         it["PERSON_DESCRIPTION"] = "persona física"
         it["COMPANY_DESCRIPTION"] = "persona jurídica"
         it["CUIT_CUIL"] = "CUIT/CUIL"
         it["INVALID_LENGTH"] = "CUIT debe tener 11 dígitos numéricos"
         it["ONLY_DIGITS"] = "CUIT solo puede contener números"
         it["INVALID_ENTITY_CODE"] = "Código de entidad inválido"
      }

      CBU::class.register {
         it["BRANCH"] = "Entidad/sucursal"
         it["ACCOUNT"] = "Número de cuenta"
         it["INVALID_LENGTH"] = "CBU debe tener 22 dígitos"
         it["ONLY_DIGITS"] = "CBU solo puede contener números"
      }

      CardNumber::class.register {
         it["CARD_NUMBER"] = "Número de tarjeta"
         it["INVALID_LENGTH"] = "Longitud del número de tarjeta inválida"
         it["ONLY_DIGITS"] = "El número de tarjeta solo puede contener números"
      }

      NameUtils::class.register {
         it["INVALID_FORMAT"] = "Nombre inválido"
      }

      CheckDigitValidator::class.register {
         it["INVALID_CHECK_DIGIT"] = "Dígito verificador inválido para"
      }

      Catalog::class.register {
         it["NO_CLASS_NAME"] = "La clase debe tener nombre simple"
         it["EMPTY_ITERABLE"] = "No se puede inferir la clase de un iterable vacío"
      }

      CustomerService::class.register {
         it["CUSTOMER_NOT_FOUND"] = "Cliente no encontrado"
         it["ID_CANT_BE_EMPTY"] = "Debe especificar un Customer.ID"
         it["INVALID_CUSTOMER_ID"] = "Customer.ID inválido"
      }

      Any::class.register {
         it["TEST"] = "Prueba"
         it["NOT_IMPLEMENTED"] = "No implementado"
      }

   }
}
