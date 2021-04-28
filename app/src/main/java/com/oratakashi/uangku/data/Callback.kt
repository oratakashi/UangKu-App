package com.oratakashi.uangku.data

/**
 * Created by Abdul Hafiidh Septiandaru
 * 28 April 2021
 * github : https://github.com/oratakashi
 **/
interface Callback<T> {
    fun Result(data: T)

    fun Error(error: Throwable?)
}