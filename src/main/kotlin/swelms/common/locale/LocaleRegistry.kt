package swelms.common.locale

object LocaleRegistry {

   val langsMap: MutableMap<String, Lang> = mutableMapOf()
   val regionalsMap: MutableMap<String, Regional> = mutableMapOf()

   @JvmStatic
   fun register(vararg cfgs: LocaleComponent) {
      cfgs.forEach { cfg ->
         when (cfg) {
            is Lang -> langsMap[cfg.locale_id] = cfg
            is Regional -> regionalsMap[cfg.locale_id] = cfg
         }
      }
   }

   @JvmStatic
   fun unregister(cfg: LocaleComponent) {
      when (cfg) {
         is Lang -> langsMap.remove(cfg.locale_id)
         is Regional -> regionalsMap.remove(cfg.locale_id)
      }
   }

}
