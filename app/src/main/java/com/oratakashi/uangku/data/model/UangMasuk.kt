package com.oratakashi.uangku.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Abdul Hafiidh Septiandaru
 * 28 April 2021
 * github : https://github.com/oratakashi
 **/

@Entity
data class UangMasuk(
    @PrimaryKey(autoGenerate = true)
    val UangMasukID : Int?,
    val terimaDari : String,
    val keterangan : String,
    val jumlah : Int,
    val date : String?,
    val nomor : String?
)
