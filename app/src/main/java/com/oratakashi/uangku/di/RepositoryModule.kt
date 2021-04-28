package com.oratakashi.uangku.di

import com.oratakashi.uangku.data.db.RoomDB
import com.oratakashi.uangku.repository.DataRepository
import com.oratakashi.uangku.repository.local.LocalRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
class RepositoryModule {
    @Provides
    @Singleton
    fun provideLocalRepository(
        db : RoomDB,
        disposable: CompositeDisposable
    ) : LocalRepository = LocalRepository(db, disposable)

    @Provides
    @Singleton
    fun provideDataRepository(
        localRepository: LocalRepository
    ) : DataRepository = DataRepository(localRepository)
}