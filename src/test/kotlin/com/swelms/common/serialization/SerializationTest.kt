package com.swelms.common.serialization

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class SerializationTest {
    @Serializable
    data class TestData(val name: String, val age: String)

    @Test
    fun decodeFromMap() {
        val map = mapOf("name" to "John", "age" to 30)
        val data: TestData = Json.decodeFromMap(map)
        
        assertEquals("John", data.name)
        assertEquals("30", data.age)
    }
}
