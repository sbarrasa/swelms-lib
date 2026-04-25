package com.swelms.common.validator

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class RuleTest {
    @Test
    fun evalCondition(){
        val rule = Rule<Int>("Debe ser positivo") { it > 0 }
        assertTrue { rule.condition(1) }
        assertFalse { rule.condition(-1) }
    }

}