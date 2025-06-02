package com.sbarrasa.repository

class IdRequiredException : RepositoryException {
   constructor() : super("id es requerida")
}