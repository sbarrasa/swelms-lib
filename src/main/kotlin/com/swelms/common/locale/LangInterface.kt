package com.swelms.common.locale


interface LangInterface: LocaleInterface {
   val textsByModule: Map<String, MutableMap<String, String>>
}
