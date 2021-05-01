package com.oratakashi.uangku.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Abdul Hafiidh Septiandaru
 * 28 April 2021
 * github : https://github.com/oratakashi
 **/

object Utils {
    @Throws(ParseException::class)
    fun dateFormat(date: String, input: String, output: String) : String{
        var format = SimpleDateFormat(input, Locale.getDefault())
        var newDate : Date? = null

        newDate = format.parse(date)

        format = SimpleDateFormat(output, Locale.getDefault())

        return format.format(newDate)
    }

    @Throws(ParseException::class)
    fun dateFormat(date: Date, output: String) : String{
        return SimpleDateFormat(output, Locale.getDefault()).format(date)
    }
}