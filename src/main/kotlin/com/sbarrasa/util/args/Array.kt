package com.sbarrasa.util.args

val Array<String>.asMap: Map<String, String> get(){
    return asMap()
}
fun Array<String>.asMap(prefix: String = ArgsMapper.DEFAULT_PREFIX,
                        separator: String = ArgsMapper.DEFAULT_SEPARATOR
): Map<String, String> {
    return ArgsMapper(this, prefix, separator).asMap
}

operator fun Array<String>.get(key: String): String? {
    return asMap[key]
}
