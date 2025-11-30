package com.swelms.common.locale


interface AbstractLangConfig: AbstractLocaleConfig {
   val textsByModule: Map<String, MutableMap<String, String>>
}
