package com.oratakashi.uangku.repository

import androidx.lifecycle.MutableLiveData
import com.oratakashi.uangku.data.Callback
import com.oratakashi.uangku.data.model.UangMasuk

/**
 * Created by Abdul Hafiidh Septiandaru
 * 28 April 2021
 * github : https://github.com/oratakashi
 **/
interface Repository {
    fun insertUangMasuk(data: UangMasuk, state : Callback<Boolean>)
    fun getUangMasuk(state: Callback<List<UangMasuk>>)
}