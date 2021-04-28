package com.oratakashi.uangku.ui.main

import com.oratakashi.uangku.data.model.UangMasuk

/**
 * Created by Abdul Hafiidh Septiandaru
 * 28 April 2021
 * github : https://github.com/oratakashi
 **/

interface MainContract {
    interface View {
        fun onResult(result : List<UangMasuk>)
        fun onError(error: Throwable?)
    }
    interface Presenter {
        fun setView(view: View)
        fun getData()
    }
}