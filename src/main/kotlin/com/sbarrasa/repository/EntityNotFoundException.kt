package com.sbarrasa.repository


class EntityNotFoundException : RepositoryException(Texts.ENTITY_NOT_FOUND) {
   object Texts {
      var ENTITY_NOT_FOUND = "Entidad no encontrada"

   }
}