package com.sbarrasa.repository

import com.sbarrasa.common.locale.Locale


class EntityNotFoundException : RepositoryException(texts["ENTITY_NOT_FOUND"]) {
   companion object {
      val texts get() = Locale.texts(EntityNotFoundException::class)
   }
}