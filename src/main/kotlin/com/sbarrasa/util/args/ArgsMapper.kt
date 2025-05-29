package com.sbarrasa.util.args

class ArgsMapper(
    args: Array<String>,
    prefix: String = DEFAULT_PREFIX,
    separator: String = DEFAULT_SEPARATOR
    ) {

    val asMap: Map<String, String> = args
        .mapNotNull { arg ->
            val parts = arg.split(separator, limit = 2)
            if ((parts.size == 2)
                && parts[0].startsWith(prefix))
                parts[0].removePrefix(prefix) to parts[1]
            else
                null

        }
        .toMap()

    operator fun get(key: String) = asMap[key]
    companion object  {
        const val DEFAULT_PREFIX = "--"
        const val DEFAULT_SEPARATOR = "="
    }

}


