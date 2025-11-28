package com.bank.locale

import com.bank.model.customer.Gender
import kotlin.test.*
import com.swelms.domain.id.cuit.Cuit
import com.swelms.common.locale.*
import com.swelms.domain.validator.ValidatorException

class LocaleConfigFullTest {

   @BeforeTest
   fun setup() {
      Locale.registerConfigs(LocaleConfig_ar, LocaleConfig_us, LocaleConfig_es, LocaleConfig_en)
   }

   @Test
   fun textChangeLang() {
      Locale.lang = "es"

      assertEquals("Masculino", Gender.M.description)

      Locale.lang = "en"
      assertEquals("Male", Gender.M.description)

      Locale.lang = null
      assertEquals("M", Gender.M.description)

   }

   @Test
   fun testCuitInvalidLengthException() {
      Locale.lang = "es"
      val exEs = assertFailsWith<ValidatorException> {
         Cuit("123")
      }
      assertEquals("CUIT/CUIL debe tener 11 dígitos numéricos", exEs.message)

      Locale.lang = "en"
      val exEn = assertFailsWith<ValidatorException> {
         Cuit("123")
      }
      assertEquals("CUIT/CUIL must have 11 numeric digits", exEn.message)
   }

   @Test
   fun testDateFormatRegional() {
      Locale.regional = "ar"
      assertEquals("dd/MM/yyyy", Locale.value("DATE_FORMAT"))

      Locale.regional = "us"
      assertEquals("MM-dd-yyyy", Locale.value("DATE_FORMAT"))
   }

   @Test
   fun testMissingRegionalKey() {
      Locale.regional = "ar"
      assertNull(Locale.valueOrNull<String>("XX"))
   }

   @Test
   fun testMissingRegional() {
      Locale.regional = null
      // No hay regional, value debería devolver null o lanzar excepción según configuración
      assertFailsWith<NoSuchElementException> {
         Locale.value<String>("DATE_FORMAT")
      }
   }
}
