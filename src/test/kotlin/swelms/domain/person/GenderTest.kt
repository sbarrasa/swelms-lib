package swelms.domain.person

import swelms.common.locale.*
import swelms.common.reflection.qProperty
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class GenderTest {
    val lang_test = Lang(locale_id = "test") {
       it[Gender.M.qProperty] = "Masculino"
       it[Gender.F.qProperty] = "Femenino"
       it[Gender.X.qProperty] = "No binario"
    }

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
        assertEquals("Masculino", Gender.M.localeDescription)
        assertEquals("Femenino", Gender.F.localeDescription)
        assertEquals("No binario", Gender.X.localeDescription)
    }


}
