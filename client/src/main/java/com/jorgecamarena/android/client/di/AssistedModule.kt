package com.jorgecamarena.android.client.di

import android.content.Context
import com.jorgecamarena.android.client.assistedInjection.RepositoryClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext

/**
 * Created by jorgecordero on Aug, 14, 2022
 **/
@Module
@InstallIn(ActivityComponent::class)
class AssistedModule {

    @Provides
    fun providesRepositoryClient(@ApplicationContext context: Context) = RepositoryClient(context)

}