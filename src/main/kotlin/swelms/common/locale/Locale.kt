package swelms.common.locale

object Locale: AbstractLocaleContext() {
   var contextProvider: ContextProvider? = null
   private val current: AbstractLocaleContext get() = contextProvider?.invoke() ?: default

   override var langId: String?
      get() = current.langId
      set(value) { current.langId = value }

   override var regionalId: String?
      get() = current.regionalId
      set(value) { current.regionalId = value }
   private val default by lazy { LocaleContext() }
}