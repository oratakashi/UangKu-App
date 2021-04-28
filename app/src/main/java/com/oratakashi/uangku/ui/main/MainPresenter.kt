package com.oratakashi.uangku.ui.main

import com.oratakashi.uangku.data.Callback
import com.oratakashi.uangku.data.model.UangMasuk
import com.oratakashi.uangku.repository.Repository
import javax.inject.Inject

/**
 * Created by Abdul Hafiidh Septiandaru
 * 28 April 2021
 * github : https://github.com/oratakashi
 **/

class MainPresenter @Inject constructor(
        private val repository: Repository
) : MainContract.Presenter {

    lateinit var views : MainContract.View

    override fun setView(view: MainContract.View) {
        views = view
    }

    override fun getData() {
        repository.getUangMasuk(
                object : Callback<List<UangMasuk>> {
                    override fun Result(data: List<UangMasuk>) {
                        views.onResult(data)
                    }

                    override fun Error(error: Throwable?) {
                        views.onError(error)
                    }
                }
        )
    }
}