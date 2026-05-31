package swelms.common.locale

object Locale: LocaleContext() {
   var contextProvider: ContextProvider? = null
   private val current: LocaleContext get() = contextProvider?.invoke() ?: default

   override var langId: String?
      get() = current.langId
      set(value) { current.langId = value }

   override var regionalId: String?
      get() = current.regionalId
      set(value) { current.regionalId = value }
   private val default by lazy {
      object : LocaleContext() {
         override var langId: String? = null
         override var regionalId: String? = null
      }
   }
}