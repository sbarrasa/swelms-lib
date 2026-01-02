package com.swelms.domain.locale

import com.swelms.common.locale.LangInterface
import com.swelms.common.locale.Locale
import com.swelms.common.reflection.qName
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class CurrencyTest {

    object CurrencyLang : LangInterface {
        override val locale_id = "test"
        override val moduleTextMap = mapOf(
            Currency::class.qName to mutableMapOf(
                "ARS" to "Peso Argentino"
            )
        )
    }

    @BeforeTest
    fun setup() {
        Locale.registerConfig(CurrencyLang)
        Locale.lang = "test"
    }

    @Test
    fun currencyProperties() {
        val ars = Currency.ARS
        assertEquals("$", ars.symbol)
        assertEquals("AR", ars.code)
        assertEquals("peso", ars.description)
    }

    @Test
    fun currencyLocaleDescription() {
        assertEquals("Peso Argentino", Currency.ARS.localeDescription)
        // Fallback to description if not in locale
        assertEquals("dollar", Currency.USD.localeDescription)
    }
}
