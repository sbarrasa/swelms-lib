package com.sbarrasa.repository



class EntityNotFoundException : RepositoryException {
    constructor(message: String): super(message)
    constructor(id: Any, message: String = "id: $id no encontrada"): this(message)
}