package com.sbarrasa.cuit

import com.sbarrasa.id.Desc


enum class EntityType(override val description: String) : Desc {
   FISICA("persona física"),
   JURIDICA("persona juridica");
}
