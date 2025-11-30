package com.swelms.common.locale

import kotlinx.serialization.Polymorphic
import kotlinx.serialization.Serializable

data class RegionalConfig(
   override val valueMap: Map<String, Any>,
   override val locale_id: String
): AbstractRegionalConfig
