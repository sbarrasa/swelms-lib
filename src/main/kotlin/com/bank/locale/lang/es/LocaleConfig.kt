package com.bank.locale.lang.es

import com.sbarrasa.common.locale.AbstractLocaleConfig
import com.sbarrasa.domain.cuit.Cuit
import com.sbarrasa.domain.cbu.CBU
import com.sbarrasa.domain.card.CardNumber
import com.sbarrasa.domain.person.NameUtils
import com.sbarrasa.domain.validator.CheckDigitValidator
import com.sbarrasa.common.collections.Catalog
import com.sbarrasa.repository.EntityNotFoundException

object LocaleConfig : AbstractLocaleConfig() {
   override fun register() {
      Cuit::class.texts {
         it["PERSON_DESCRIPTION"] = "persona física"
         it["COMPANY_DESCRIPTION"] = "persona jurídica"
         it["CUIT_CUIL"] = "CUIT/CUIL"
         it["INVALID_LENGTH"] = "CUIT debe tener 11 dígitos numéricos"
         it["ONLY_DIGITS"] = "CUIT solo puede contener números"
         it["INVALID_ENTITY_CODE"] = "Código de entidad inválido"
      }

      CBU::class.texts {
         it["BRANCH"] = "Entidad/sucursal"
         it["ACCOUNT"] = "Número de cuenta"
         it["INVALID_LENGTH"] = "CBU debe tener 22 dígitos"
         it["ONLY_DIGITS"] = "CBU solo puede contener números"
      }

      CardNumber::class.texts {
         it["CARD_NUMBER"] = "Número de tarjeta"
         it["INVALID_LENGTH"] = "Longitud del número de tarjeta inválida"
         it["ONLY_DIGITS"] = "El número de tarjeta solo puede contener números"
      }

      NameUtils::class.texts {
         it["INVALID_FORMAT"] = "Los nombres no pueden incluir caracteres especiales"
      }

      CheckDigitValidator::class.texts {
         it["INVALID_CHECK_DIGIT"] = "Dígito verificador inválido para"
      }

      Catalog::class.texts {
         it["NO_CLASS_NAME"] = "La clase debe tener nombre simple"
         it["EMPTY_ITERABLE"] = "No se puede inferir la clase de un iterable vacío"
      }

      EntityNotFoundException::class.texts {
         it["ENTITY_NOT_FOUND"] = "Entidad no encontrada"
      }
   }
}
