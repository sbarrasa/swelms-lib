package com.swelms.common.locale

import com.swelms.common.reflection.qName
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import java.io.File
import kotlin.test.*

class LocaleTestJson {

   @OptIn(ExperimentalSerializationApi::class)
   @BeforeTest
   fun setup() {
      val jsonStr = File("src/test/resources/lang_es.json").readText()
      val lang_es = Json.decodeFromString(LangConfig.serializer(), jsonStr)

      Locale.registerConfigs(lang_es)
      Locale.lang = "es"
   }

   @Test
   fun testDefault() {
      assertEquals("Prueba", localeText("TEST"))
   }

   @Test
   fun testByClass() {
      val text = Locale.text(IntRange::class.qName, "OUT_OF_RANGE").replaceSlots(5,10)
      assertEquals("El valor debe estar entre 5 y 10", text)
   }
}
