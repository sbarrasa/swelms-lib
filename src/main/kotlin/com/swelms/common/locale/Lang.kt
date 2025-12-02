package com.swelms.common.locale

import kotlinx.serialization.Serializable


@Serializable
data class Lang(
   override val locale_id: String,
   override val moduleTextMap: Map<String, MutableMap<String, String>>
): LangInterface
