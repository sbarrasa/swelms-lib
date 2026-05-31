package swelms.common.locale

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class LocaleTest {

   private class TestContext : LocaleContext() {
      override var langId: String? = null
      override var regionalId: String? = null
   }

   @BeforeTest
   fun setup() {
      Locale.contextProvider = null
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
      val ctx = TestContext()

      Locale.contextProvider = { ctx }

      Locale.langId = "es"
      Locale.regionalId = "ar"

      assertEquals("es", ctx.langId)
      assertEquals("ar", ctx.regionalId)
   }

   @Test
   fun providerRead() {
      val ctx = TestContext().apply {
         langId = "en"
         regionalId = "us"
      }

      Locale.contextProvider = { ctx }

      assertEquals("en", Locale.langId)
      assertEquals("us", Locale.regionalId)
   }

   @Test
   fun providerSwitchWrite() {
      val a = TestContext()
      val b = TestContext()

      Locale.contextProvider = { a }
      Locale.langId = "es"

      Locale.contextProvider = { b }
      Locale.langId = "en"

      assertEquals("es", a.langId)
      assertEquals("en", b.langId)
   }

   @Test
   fun providerSwitchRead() {
      val a = TestContext().apply { langId = "es" }
      val b = TestContext().apply { langId = "en" }

      Locale.contextProvider = { a }
      assertEquals("es", Locale.langId)

      Locale.contextProvider = { b }
      assertEquals("en", Locale.langId)
   }

   @Test
   fun fallbackToDefault() {
      Locale.langId = "es"

      val ctx = TestContext()
      Locale.contextProvider = { ctx }

      Locale.langId = "en"

      Locale.contextProvider = null

      assertEquals("es", Locale.langId)
      assertEquals("en", ctx.langId)
   }

   @Test
   fun transientProvider() {
      Locale.contextProvider = { TestContext() }

      Locale.langId = "es"

      assertNull(Locale.langId)
   }
}