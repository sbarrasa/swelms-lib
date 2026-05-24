package swelms.common.locale


interface LangInterface: LocaleInterface {
   val moduleTextMap: Map<String, MutableMap<String, String>>
}
