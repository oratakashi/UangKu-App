package com.oratakashi.uangku.data.db

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

/**
 * Created by Abdul Hafiidh Septiandaru
 * 28 April 2021
 * github : https://github.com/oratakashi
 **/
object Migration {
    val MIGRATION_1_2: Migration = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            // Create the new table
            database.execSQL(
                    "CREATE TABLE UangMasukTemp (UangMasukID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            "terimaDari TEXT not null, keterangan TEXT not null, " +
                            "jumlah INTEGER not null, date TEXT, nomor TEXT)");

            // Copy the data
            database.execSQL(
                    "INSERT INTO UangMasukTemp (UangMasukID, terimaDari, keterangan, jumlah) " +
                            "SELECT UangMasukID, terimaDari, keterangan, jumlah FROM UangMasuk");
            // Remove the old table
            database.execSQL("DROP TABLE UangMasuk");
            // Change the table name to the correct one
            database.execSQL("ALTER TABLE UangMasukTemp RENAME TO UangMasuk");
        }
    }
}
