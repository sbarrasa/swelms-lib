package swelms.common.locale

import swelms.common.text.replaceSlots
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import java.io.File
import kotlin.test.*

class LocaleTestJson {

   @OptIn(ExperimentalSerializationApi::class)
   @BeforeTest
   fun setup() {
      val jsonStr = File("src/test/resources/lang_es.json").readText()
      val lang_es = Json.decodeFromString<Lang>(jsonStr)

      LocaleRegistry.register(lang_es)
      Locale.langId = "es_test"
   }

   @Test
   fun testDefault() {
      assertEquals("Prueba", Locale.text("TEST"))
   }

   @Test
   fun testByClass() {
      val text = Locale.text("OUT_OF_RANGE").replaceSlots(5,10)
      assertEquals("El valor debe estar entre 5 y 10", text)
   }
}
