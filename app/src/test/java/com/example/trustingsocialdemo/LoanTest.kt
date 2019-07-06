package com.example.trustingsocialdemo

import com.example.trustingsocialdemo.util.validateIdentity
import com.example.trustingsocialdemo.util.validateIncome
import com.example.trustingsocialdemo.util.validatePhone
import org.junit.Assert
import org.junit.Test
import java.util.*

/**
 * Created by khangpv on 2019-07-06.
 * FinOs
 */
class LoanTest {
    @Test
    fun testValidatePhone() {
        val phonePrefix = setOf(
            "0120", "0121", "0122", "0123", "0124", "0125", "0126",
            "0127", "0128", "0129", "0162", "0163", "0164", "0165",
            "0166", "0167", "0168", "0169", "0186", "0188", "0199",
            "086", "088", "089", "090", "091", "092", "093", "094",
            "095", "096", "097", "098", "099"
        )
        phonePrefix.forEach {
            var input = StringBuilder(it)
            for (i in 0 until 7) {
                val nextInt = Random().nextInt(10)
                input.append(nextInt)
            }
            val validatePhone = validatePhone(input.toString())
            Assert.assertEquals(true, validatePhone)
        }


        val invalid = listOf("016561022345", "0704545456")
        invalid.forEach {
            Assert.assertEquals(false, validatePhone(it))
        }
    }

    @Test
    fun testValidateIdentity() {
        val valid = listOf("186852273", "345676564565")
        valid.forEach {
            Assert.assertEquals(true, validateIdentity(it))
        }

        val invalid = listOf("18656545", "1823232345", "1234343434567")
        invalid.forEach {
            Assert.assertEquals(false, validateIdentity(it))
        }
    }

    @Test
    fun testValidateIncome() {
        val valid = listOf("3000000", "5000000")
        valid.forEach {
            Assert.assertEquals(true, validateIncome(it))
        }

        val invalid = "2999999"
        Assert.assertEquals(false, validateIncome(invalid))
    }
}