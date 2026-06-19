package swelms.common.locale

import swelms.common.reflection.qProperty

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

val String.locale get() = Locale.text(this)

