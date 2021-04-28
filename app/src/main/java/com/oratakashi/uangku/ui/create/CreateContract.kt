package com.oratakashi.uangku.ui.create

/**
 * Created by Abdul Hafiidh Septiandaru
 * 28 April 2021
 * github : https://github.com/oratakashi
 **/

interface CreateContract {
    interface View {
        fun onResult(result: Boolean)
        fun onError(error : Throwable?)
    }
    interface Presenter {
        fun setView(view: View)
        fun insertData(
            diterima : String,
            keterangan: String,
            jumlah : String
        )
    }
}