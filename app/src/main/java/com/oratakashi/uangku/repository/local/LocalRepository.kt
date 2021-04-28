package com.oratakashi.uangku.repository.local

import androidx.lifecycle.MutableLiveData
import com.oratakashi.uangku.data.Callback
import com.oratakashi.uangku.data.db.RoomDB
import com.oratakashi.uangku.data.model.UangMasuk
import com.oratakashi.uangku.repository.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Abdul Hafiidh Septiandaru
 * 28 April 2021
 * github : https://github.com/oratakashi
 **/

class LocalRepository @Inject constructor(
    private val db : RoomDB,
    private val disposable: CompositeDisposable
): Repository{
    override fun insertUangMasuk(data: UangMasuk, state: Callback<Boolean>) {
        db.income().add(data)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .toFlowable()
            .map { Unit }
            .onErrorReturn{ state.Error(it) }
            .subscribe{
                state.Result(true)
            }
            .let { return@let disposable::add }
    }

    override fun getUangMasuk(state: Callback<List<UangMasuk>>) {
        db.income().getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toFlowable()
                .doOnError {
                    state.Error(it)
                }
                .subscribe {
                    state.Result(it)
                }
                .let { return@let disposable::add }
    }
}