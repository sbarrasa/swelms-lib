package com.swelms.common.math

import com.swelms.common.type.Restricted

class Natural(value: Int): Restricted<Int>(value, { it > 1})