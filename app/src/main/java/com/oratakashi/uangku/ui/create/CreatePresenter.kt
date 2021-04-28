package com.oratakashi.uangku.ui.create

import com.oratakashi.uangku.data.Callback
import com.oratakashi.uangku.data.model.UangMasuk
import com.oratakashi.uangku.repository.Repository
import javax.inject.Inject

/**
 * Created by Abdul Hafiidh Septiandaru
 * 28 April 2021
 * github : https://github.com/oratakashi
 **/

class CreatePresenter @Inject constructor(
    private val repository: Repository
) : CreateContract.Presenter {

    lateinit var views :CreateContract.View

    override fun setView(view: CreateContract.View) {
        views = view
    }

    override fun insertData(diterima: String, keterangan: String, jumlah: String) {
        repository.insertUangMasuk(
            UangMasuk(
                null,
                diterima,
                keterangan,
                jumlah.toInt()
            ),
            object : Callback<Boolean> {
                override fun Result(data: Boolean) {
                    views.onResult(data)
                }

                override fun Error(error: Throwable?) {
                    views.onError(error)
                }
            }
        )
    }
}