package com.oratakashi.uangku.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.oratakashi.uangku.data.db.dao.UangMasukDao
import com.oratakashi.uangku.data.model.UangMasuk

/**
 * Created by Abdul Hafiidh Septiandaru
 * 28 April 2021
 * github : https://github.com/oratakashi
 **/
@Database(
    entities = [
        UangMasuk::class
    ],
    version = 1
)
abstract class RoomDB : RoomDatabase() {

    abstract fun income() : UangMasukDao

    companion object {

        @Volatile private var instance : RoomDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            RoomDB::class.java,
            "UangKu.db"
        )
            .build()

    }
}