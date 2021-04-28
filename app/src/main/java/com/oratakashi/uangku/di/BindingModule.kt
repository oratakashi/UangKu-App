package com.oratakashi.uangku.di

import com.oratakashi.uangku.repository.DataRepository
import com.oratakashi.uangku.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by Abdul Hafiidh Septiandaru
 * 28 April 2021
 * github : https://github.com/oratakashi
 **/

@Module
@InstallIn(SingletonComponent::class)
abstract class BindingModule {
    @Binds
    abstract fun bindRepository(
        dataRepository: DataRepository
    ) : Repository
}