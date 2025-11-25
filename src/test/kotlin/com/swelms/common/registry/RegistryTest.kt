package com.swelms.common.registry

import kotlin.test.*

class RegistryTest {

    @Test
    fun registerInstance() {
        val registryFactory = RegistryFactory<String, String>()
        val instance = "test instance"

        registryFactory.register("key1", instance)

        assertEquals(instance, registryFactory.get("key1"))
    }

    @Test
    fun registerConstructor() {
        val registryFactory = RegistryFactory<String, String>()

        registryFactory.register("key1") { "created instance" }

        assertEquals("created instance", registryFactory.create("key1"))
    }

    @Test
    fun getLazyCreatesInstance() {
        val registryFactory = RegistryFactory<String, String>()

        registryFactory.register("key1") { "lazy instance" }

        val result = registryFactory.get("key1")
        assertEquals("lazy instance", result)
    }

    @Test
    fun getCachesInstance() {
        val registryFactory = RegistryFactory<String, Int>()
        var counter = 0

        registryFactory.register("key1") { ++counter }

        val first = registryFactory.get("key1")
        val second = registryFactory.get("key1")

        assertEquals(1, first)
        assertEquals(1, second)
        assertEquals(1, counter)
    }

    @Test
    fun unregisterRemovesAll() {
        val registryFactory = RegistryFactory<String, String>()

        registryFactory.register("key1", "instance")
        registryFactory.register("key1") { "constructor" }

        registryFactory.unregister("key1")

        assertFailsWith<RegistryException> {
            registryFactory.get("key1")
        }
    }

    @Test
    fun createThrowsWhenNotRegistered() {
        val registryFactory = RegistryFactory<String, String>()

        val exception = assertFailsWith<RegistryException> {
            registryFactory.create("nonexistent")
        }

        assertTrue(exception.message?.contains("nonexistent") ?: false)
    }

    @Test
    fun getThrowsWhenNotRegistered() {
        val registryFactory = RegistryFactory<String, String>()

        assertFailsWith<RegistryException> {
            registryFactory.get("nonexistent")
        }
    }

    @Test
    fun registerInstanceOverwrites() {
        val registryFactory = RegistryFactory<String, String>()

        registryFactory.register("key1", "first")
        registryFactory.register("key1", "second")

        assertEquals("second", registryFactory.get("key1"))
    }

    @Test
    fun registerConstructorOverwrites() {
        val registryFactory = RegistryFactory<String, String>()

        registryFactory.register("key1") { "first" }
        registryFactory.register("key1") { "second" }

        assertEquals("second", registryFactory.create("key1"))
    }

    @Test
    fun createAlwaysReturnsNew() {
        val registryFactory = RegistryFactory<String, Int>()
        var counter = 0

        registryFactory.register("key1") { ++counter }

        val first = registryFactory.create("key1")
        val second = registryFactory.create("key1")

        assertEquals(1, first)
        assertEquals(2, second)
    }

    @Test
    fun worksWithComplexTypes() {
        data class TestClass(val value: String)

        val registryFactory = RegistryFactory<String, TestClass>()

        registryFactory.register("key1") { TestClass("test") }

        val result = registryFactory.get("key1")
        assertEquals("test", result.value)
    }
}
