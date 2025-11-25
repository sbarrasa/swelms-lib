package com.swelms.common.registry

class RegistryException(msg: String): NoSuchElementException(msg){
   constructor(key: Any?) : this("$NO_ELEMENT_REGISTERED $key")
   companion object {
      var NO_ELEMENT_REGISTERED = "No hay elemento registrado para:"
   }
}
