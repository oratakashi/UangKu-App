package com.oratakashi.uangku.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.oratakashi.uangku.data.model.UangMasuk
import io.reactivex.Single

/**
 * Created by Abdul Hafiidh Septiandaru
 * 28 April 2021
 * github : https://github.com/oratakashi
 **/

@Dao
interface UangMasukDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(data : UangMasuk) : Single<Long>

    @Query("Select * from uangmasuk")
    fun getAll() : Single<List<UangMasuk>>
}