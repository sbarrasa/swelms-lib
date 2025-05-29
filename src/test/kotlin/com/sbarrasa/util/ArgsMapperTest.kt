package com.sbarrasa.util


import com.sbarrasa.util.args.ArgsMapper
import com.sbarrasa.util.args.asMap
import kotlin.test.*

class ArgsMapperTest {

    private val args = arrayOf("--repo=mem", "--user=admin", "--flag")

    @Test
    fun testAsMap() {
        val mainArgs = ArgsMapper(args)
        val map = mainArgs.asMap

        assertEquals("mem", map["repo"])
        assertEquals("admin", map["user"])
        assertNull(map["flag"], "flag no tiene valor asignado, debe ser null")
    }

    @Test
    fun testOperatorGet() {
        val mainArgs = ArgsMapper(args)
        assertEquals("mem", mainArgs["repo"])
        assertEquals("admin", mainArgs["user"])
        assertNull(mainArgs["flag"])
    }

    @Test
    fun testExtensionFunctionDefaultParams() {
        val map = args.asMap()
        assertEquals("mem", map["repo"])
        assertEquals("admin", map["user"])
        assertNull(map["flag"])
    }

    @Test
    fun testCustomPrefixAndSeparator() {
        val argsCustom = arrayOf("++repo:mem", "++user:admin")
        val map = argsCustom.asMap(prefix = "++", separator = ":")
        assertEquals("mem", map["repo"])
        assertEquals("admin", map["user"])
    }

    @Test
    fun testEmptyArgs() {
        val emptyArgs = emptyArray<String>()
        val map = emptyArgs.asMap()
        assertEquals(0, map.size)
    }
}