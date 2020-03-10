package com.paivadeveloper.ibmtest.util

import junit.framework.TestCase

class DateUtilTest : TestCase() {

    fun testGetFormattedDate() {
        assertEquals(DateUtil().getFormattedDate(DATE_INPUT), DATE_OUTPUT)
    }

    companion object{
        const val DATE_INPUT = "2018-07-25"
        const val DATE_OUTPUT = "25/07/2018"
    }
}