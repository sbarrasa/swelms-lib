package swelms.common.locale

object LocaleRegistry {

   val langMap: MutableMap<String, Lang> = mutableMapOf()
   val regionalMap: MutableMap<String, Regional> = mutableMapOf()

   @JvmStatic
   fun register(vararg cfgs: LocaleConfig) {
      cfgs.forEach { cfg ->
         when (cfg) {
            is Lang -> langMap[cfg.locale_id] = cfg
            is Regional -> regionalMap[cfg.locale_id] = cfg
         }
      }
   }

   @JvmStatic
   fun unregister(vararg cfgs: LocaleConfig) {
      cfgs.forEach { cfg ->
         when (cfg) {
            is Lang -> langMap.remove(cfg.locale_id)
            is Regional -> regionalMap.remove(cfg.locale_id)
         }
      }
   }
}
