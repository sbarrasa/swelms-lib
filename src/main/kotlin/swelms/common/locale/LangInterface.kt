package swelms.common.locale


interface LangInterface: LocaleDataInterface {
   val moduleTextMap: Map<String, MutableMap<String, String>>
}
