package com.swelms.common.locale

abstract class AbstractLocaleConfig {
   abstract val locale_id: String
   fun load() = onLoad()
   protected abstract fun onLoad()
   abstract fun unload()
}