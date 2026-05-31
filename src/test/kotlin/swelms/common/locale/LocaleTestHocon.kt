package swelms.common.locale

import swelms.common.text.replaceSlots
import com.typesafe.config.ConfigFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.hocon.Hocon
import kotlinx.serialization.hocon.decodeFromConfig
import kotlin.test.*

class LocaleTestHocon {

   @OptIn(ExperimentalSerializationApi::class)
   @BeforeTest
   fun setup(){
      val cfg = ConfigFactory.parseResources("lang_es.conf")
      val lang_es = Hocon.decodeFromConfig<Lang>(cfg)

      val lang_en = Hocon.decodeFromConfig(
         Lang.serializer(),
         ConfigFactory.parseResources("lang_en.conf")
      )

      LocaleRegistry.register(lang_es, lang_en)
      LocaleContext.langId = "es"
   }

   @Test
   fun testDefault() {
      assertEquals("Prueba", LocaleContext.text("TEST"))
   }

   @Test
   fun testByClass(){
      val text = LocaleContext.text("OUT_OF_RANGE").replaceSlots(5,10)
      assertEquals("El valor debe estar entre 5 y 10", text)
   }

   @Test
   fun testWithSlots(){
      LocaleContext.langId = "es"
      assertEquals("El producto alcohol está por vencer en 10 días",
         LocaleContext.text("NEAR_EXPIRATION").replaceSlots("alcohol", 10))

   }

}