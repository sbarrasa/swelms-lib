package com.swelms.common.locale

import com.swelms.common.reflection.qName
import com.typesafe.config.ConfigFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.hocon.Hocon
import kotlin.test.*

class LocaleTestHocon {

   @OptIn(ExperimentalSerializationApi::class)
   @BeforeTest
   fun setup(){
      val cfg = ConfigFactory.parseResources("lang_es.conf")
      val lang_es = Hocon.decodeFromConfig(LangConfig.serializer(), cfg)

      Locale.registerConfigs(lang_es)
      Locale.lang = "es"
   }

   @Test
   fun testDefault() {
      assertEquals("Prueba", localeText("TEST"))
   }

   @Test
   fun testByClass(){
      val text = Locale.text(IntRange::class.qName, "OUT_OF_RANGE").replaceSlots(5,10)
      assertEquals("El valor debe estar entre 5 y 10", text)
   }

}