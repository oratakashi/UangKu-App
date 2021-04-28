package com.oratakashi.uangku.di

import com.oratakashi.uangku.repository.Repository
import com.oratakashi.uangku.ui.create.CreatePresenter
import com.oratakashi.uangku.ui.main.MainPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Abdul Hafiidh Septiandaru
 * 28 April 2021
 * github : https://github.com/oratakashi
 **/

@Module
@InstallIn(SingletonComponent::class)
class PresenterModule {
    @Provides
    @Singleton
    fun provideCreatePresenter(
        repository: Repository
    ) = CreatePresenter(repository)

    @Provides
    @Singleton
    fun provideMainPresenter(
            repository: Repository
    ) = MainPresenter(repository)
}