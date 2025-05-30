package com.sbarrasa.repository

class IdRequiredException: RepositoryException {
    constructor(message: String): super(message)
    constructor(): super("id es requerida")
}