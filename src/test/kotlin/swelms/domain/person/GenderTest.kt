package swelms.domain.person

import swelms.common.locale.*
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class GenderTest {

    val lang_test = Lang(locale_id = "test",
          "M" to "Masculino",
          "F" to "Femenino",
          "X" to "No binario"
       )


    @BeforeTest
    fun setup() {
        LocaleRegistry.register(lang_test)
        Locale.langId = "test"
    }

   @AfterTest
   fun shutdown(){
      LocaleRegistry.unregister(lang_test)
   }
    @Test
    fun genderDescription() {
        assertEquals("Masculino", Gender.M.description)
        assertEquals("Femenino", Gender.F.description)
        assertEquals("No binario", Gender.X.description)
    }
}
