package swelms.common.locale

import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class LocaleContextTest {
   val currentContextProvider = Locale.contextProvider

   @BeforeTest
   fun setup() {
      Locale.contextProvider = null
   }

   @AfterTest
   fun teardown() {
      Locale.contextProvider = currentContextProvider
   }

   @Test
   fun defaultContext() {
      Locale.langId = "es"
      Locale.regionalId = "ar"

      assertEquals("es", Locale.langId)
      assertEquals("ar", Locale.regionalId)
   }

   @Test
   fun providerContext() {
      val ctx = LocaleContext()

      Locale.contextProvider = { ctx }

      Locale.langId = "es"
      Locale.regionalId = "ar"

      assertEquals("es", ctx.langId)
      assertEquals("ar", ctx.regionalId)
   }

   @Test
   fun providerRead() {
      val ctx = LocaleContext()
      ctx.langId = "en"
      ctx.regionalId = "us"

      Locale.contextProvider = { ctx }

      assertEquals("en", Locale.langId)
      assertEquals("us", Locale.regionalId)
   }

   @Test
   fun providerSwitchWrite() {
      val a = LocaleContext()
      val b = LocaleContext()

      Locale.contextProvider = { a }
      Locale.langId = "es"

      Locale.contextProvider = { b }
      Locale.langId = "en"

      assertEquals("es", a.langId)
      assertEquals("en", b.langId)
   }

   @Test
   fun providerSwitchRead() {
      val a = LocaleContext().apply { langId = "es" }
      val b = LocaleContext().apply { langId = "en" }

      Locale.contextProvider = { a }
      assertEquals("es", Locale.langId)

      Locale.contextProvider = { b }
      assertEquals("en", Locale.langId)
   }

   @Test
   fun fallbackToDefault() {
      Locale.langId = "es"

      val ctx = LocaleContext()
      Locale.contextProvider = { ctx }

      Locale.langId = "en"

      Locale.contextProvider = null

      assertEquals("es", Locale.langId)
      assertEquals("en", ctx.langId)
   }

   @Test
   fun transientProvider() {
      Locale.contextProvider = { LocaleContext() }

      Locale.langId = "es"

      assertNull(Locale.langId)
   }


}