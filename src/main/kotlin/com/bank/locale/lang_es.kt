package com.bank.locale

import com.bank.database.CustomerService
import com.bank.model.products.CheckingAccount
import com.bank.model.products.CreditCardProduct
import com.bank.model.products.DebitCardProduct
import com.bank.model.products.SavingAccount
import com.bank.model.products.structure.Product
import com.swelms.domain.person.Gender
import com.swelms.common.collections.Catalog
import com.swelms.common.locale.LangBuilder
import com.swelms.common.text.snakeCase
import com.swelms.domain.id.card.CardNumber
import com.swelms.domain.id.cbu.CBU
import com.swelms.domain.id.cuit.Cuit
import com.swelms.domain.id.cuit.CuitEntityCodes
import com.swelms.domain.person.name.FullName
import com.swelms.domain.person.name.NamePart
import com.swelms.domain.validator.CheckDigitValidator
import com.swelms.domain.locale.Currency

val lang_es = LangBuilder("es") {
   defaults {
      key["NO_CLASS_NAME"] = "La clase debe tener un nombre simple"
      key["TEST"] = "Prueba"
      key["NOT_IMPLEMENTED"] = "Aún no está implementado"
      key["OUT_OF_RANGE"] = "El valor debe estar entre {1} y {2}"
      key["INVALID_LENGTH"] = "{0} debe tener {1} dígitos numéricos"
      key["ONLY_DIGITS"] = "{0} sólo puede contener dígitos numérico"
   }

   module<Cuit.EntityType> {
      key["PERSON"] = "persona física"
      key["COMPANY"] = "persona jurídica"
   }

   module<CuitEntityCodes> {
      key["20"] = "(masculino)"
      key["23"] = "(por duplicación)"
      key["24"] = "(por duplicación)"
      key["25"] = "(por duplicación)"
      key["26"] = "(por duplicación)"
      key["27"] = "(femenino)"
   }

   module<Cuit> {
      key["CUIT"] = "CUIT/CUIL"
      key["INVALID_ENTITY_CODE"] = "Código de entidad inválido"
   }

   module<CBU> {
      key["BRANCH"] = "Entidad/sucursal"
      key["ACCOUNT"] = "Número de cuenta"
   }

   module<CardNumber> {
      key["CARD_NUMBER"] = "Número de tarjeta"
      key["INVALID_LENGTH"] = "{0}: longitud inválida"
   }

   module<NamePart> {
      key["INVALID_FORMAT"] = "Los nombres sólo pueden inclukey letras, apóstrofes y acentos"
   }

   module<FullName> {
      key["INVALID_FORMAT"] = "Formato valido debe ser 'Apellidos, Nombres'"
   }

   module<CheckDigitValidator> {
      key["INVALID_CHECK_DIGIT"] = "Dígito verificador inválido para {0}"
   }

   module<Catalog> {
      key["NO_CLASS_NAME"] = "La clase debe tener nombre"
   }

   module<CustomerService> {
      key["CUSTOMER_NOT_FOUND"] = "Cliente {1} no encontrado"
      key["ID_CANT_BE_EMPTY"] = "Debe especificar un Customer ID"
      key["INVALID_CUSTOMER_ID"] = "Customer ID inválido: {1}"
   }

   module<Gender> {
      key[Gender.M.name] = "Masculino"
      key[Gender.F.name] = "Femenino"
      key[Gender.X.name] = "Sin definición"
   }

   module<Currency> {
      key[Currency.ARS.name] = "pesos argentinos"
      key[Currency.USD.name] = "dólares estadounidenses"
      key[Currency.EUR.name] = "euros"
      key[Currency.BRL.name] = "real brasileño"
   }

   module(Product.MODULE){
      key["TD"] = "Tarjeta de débito"
      key["TC"] = "Tarjeta de crédito"
      key["CC"] = "Checking Account"
      key["CA"] = "Savings Account"
   }


}

