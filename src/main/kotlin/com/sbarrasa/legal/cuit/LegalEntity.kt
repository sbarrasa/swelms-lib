package com.sbarrasa.legal.cuit

import com.sbarrasa.id.Desc

enum class LegalEntity(override val description: String) : Desc {
   FISICA("persona física"),
   JURIDICA("persona juridica");
}