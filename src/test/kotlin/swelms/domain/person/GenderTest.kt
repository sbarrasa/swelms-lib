package swelms.domain.person

import swelms.common.locale.Lang
import swelms.common.locale.Locale
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class GenderTest {

    val lang_test = Lang(locale_id = "test") {
       component<Gender> {
          it["M"] = "Masculino"
          it["F"] = "Femenino"
          it["X"] = "No binario"
       }
    }

    @BeforeTest
    fun setup() {
        Locale.register(lang_test)
        Locale.lang = "test"
    }

   @AfterTest
   fun shutdown(){
      Locale.unregister(lang_test)
   }
    @Test
    fun genderDescription() {
        assertEquals("Masculino", Gender.M.description)
        assertEquals("Femenino", Gender.F.description)
        assertEquals("No binario", Gender.X.description)
    }
}
