package com.paivadeveloper.ibmtest.util

import java.text.SimpleDateFormat
import java.util.*

class DateUtil {

    fun getFormattedDate(date: String): String {
        val formatToDate = SimpleDateFormat("yyyy-MM-dd")
        val date: Date = formatToDate.parse(date)
        val formatDateToString = SimpleDateFormat("dd/MM/yyyy")
        return formatDateToString.format(date)
    }
}