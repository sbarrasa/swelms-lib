package com.swelms.common.locale

abstract class AbstractLocaleConfig {
   abstract val key: String
   fun load() = onLoad()
   protected abstract fun onLoad()
   abstract fun unload()
}