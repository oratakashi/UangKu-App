package com.oratakashi.uangku.repository

import androidx.lifecycle.MutableLiveData
import com.oratakashi.uangku.data.Callback
import com.oratakashi.uangku.data.model.UangMasuk
import com.oratakashi.uangku.repository.local.LocalRepository
import javax.inject.Inject

/**
 * Created by Abdul Hafiidh Septiandaru
 * 28 April 2021
 * github : https://github.com/oratakashi
 **/

class DataRepository @Inject constructor(
    private val localRepository: LocalRepository
) : Repository{
    override fun insertUangMasuk(data: UangMasuk, state: Callback<Boolean>) {
        localRepository.insertUangMasuk(data, state)
    }

    override fun getUangMasuk(state: Callback<List<UangMasuk>>) {
        localRepository.getUangMasuk(state)
    }
}