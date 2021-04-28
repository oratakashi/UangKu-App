package com.oratakashi.uangku.di

import android.content.Context
import com.oratakashi.uangku.data.db.RoomDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created by Abdul Hafiidh Septiandaru
 * 28 April 2021
 * github : https://github.com/oratakashi
 **/

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) : RoomDB = RoomDB(context)

    @Provides
    @Singleton
    fun provideDisposable() : CompositeDisposable = CompositeDisposable()
}