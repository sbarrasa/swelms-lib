package com.sbarrasa.common.system


object SysProp: HashMap<String, String>() {
   init {
      this.putAll(getEnv())
      this.putAll(getJVMArgs().asMap)
   }

   fun getEnv(): Map<String, String> = System.getenv()

   fun getJVMArgs(): Array<String>{
      val cmd = System.getProperty("sun.java.command") ?: return emptyArray()
      return cmd.split(" ").drop(1).toTypedArray()
   }


}