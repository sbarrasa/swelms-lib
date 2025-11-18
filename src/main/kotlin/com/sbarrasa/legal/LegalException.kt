package com.sbarrasa.legal

class LegalException(override val message: String?) : IllegalArgumentException(message)