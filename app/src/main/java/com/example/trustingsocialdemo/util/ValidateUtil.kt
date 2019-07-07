package com.example.trustingsocialdemo.util

import java.math.BigDecimal

/**
 * Created by khangpv on 2019-07-06.
 * FinOs
 */


val phonePrefix = setOf(
    "0120", "0121", "0122", "0123", "0124", "0125", "0126",
    "0127", "0128", "0129", "0162", "0163", "0164", "0165",
    "0166", "0167", "0168", "0169", "0186", "0188", "0199",
    "086", "088", "089", "090", "091", "092", "093", "094",
    "095", "096", "097", "098", "099"
)

fun isEmpty(value: String?) = value == null || value.isEmpty()
fun validatePhone(value: String): Boolean {
    if (isEmpty(value) || !(value.length == 11 || value.length == 10)) {
        return false
    } else {
        phonePrefix.forEach {
            if (it == value.substring(0, it.length)) return true
        }
    }
    return false
}


fun validateIdentity(value: String): Boolean {
    return isEmpty(value) ||
            value.matches(regex = Regex("(^[0-9])\\w+\$")) && (value.length == 9 || value.length == 12)
}


fun validateFullName(value: String): Boolean {
    return !isEmpty(value)
}

fun validateProvince(value: String): Boolean {
    return !isEmpty(value)
}

fun validateIncome(value: String): Boolean {
    return !(isEmpty(value) || BigDecimal(value) < BigDecimal.valueOf(3000000))
}