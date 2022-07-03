package com.jorgecamarena.android.client.di

import com.jorgecamarena.android.client.singletonInstance.SingletonSampleInner
import com.jorgecamarena.android.client.singletonInstance.SingletonSampleRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by jorgecordero on Jul, 03, 2022
 **/
@Module
@InstallIn(SingletonComponent::class)
object SingletonModule {

    @Provides
    fun providesSingletonInner(): SingletonSampleInner {
        return SingletonSampleInner()
    }

    @Provides
    @Singleton
    fun providesSingletonRepo(singletonSampleInner: SingletonSampleInner): SingletonSampleRepo {
        return SingletonSampleRepo(singletonSampleInner)
    }


}