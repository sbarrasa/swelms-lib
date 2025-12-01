package com.swelms.common.locale

import kotlinx.serialization.Serializable


@Serializable
data class LangConfig(
   override val locale_id: String,
   override val textsByModule: Map<String, MutableMap<String, String>>
): LangInterface
