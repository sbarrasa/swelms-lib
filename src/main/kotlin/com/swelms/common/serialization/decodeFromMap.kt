package com.swelms.common.serialization

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.decodeFromJsonElement

inline fun <reified T> Json.decodeFromMap(map: Map<String, Any>): T {
   val jsonObject = JsonObject(
      map.mapValues { (_, v) -> JsonPrimitive(v.toString()) }
   )
   return decodeFromJsonElement(jsonObject)
}