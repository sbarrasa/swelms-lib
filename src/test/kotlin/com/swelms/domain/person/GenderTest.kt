package com.swelms.domain.person

import com.swelms.common.locale.LangInterface
import com.swelms.common.locale.Locale
import com.swelms.common.reflection.qName
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class GenderTest {

    object GenderLang : LangInterface {
        override val locale_id = "test"
        override val moduleTextMap = mapOf(
            Gender::class.qName to mutableMapOf(
                "M" to "Masculino",
                "F" to "Femenino",
                "X" to "No binario"
            )
        )
    }

    @BeforeTest
    fun setup() {
        Locale.registerConfig(GenderLang)
        Locale.lang = "test"
    }

    @Test
    fun genderDescription() {
        assertEquals("Masculino", Gender.M.description)
        assertEquals("Femenino", Gender.F.description)
        assertEquals("No binario", Gender.X.description)
    }
}
