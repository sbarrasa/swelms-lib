package com.sbarrasa.common.collections

class FallbackStringMap(private val backing: StringMap) : StringMap {
   override val entries get() = backing.entries
   override val keys get() = backing.keys
   override val values get() = backing.values
   override val size get() = backing.size
   override fun containsKey(key: String) = backing.containsKey(key)
   override fun containsValue(value: String) = backing.containsValue(value)
   override fun get(key: String): String = backing[key] ?: key
   override fun isEmpty() = backing.isEmpty()
}
