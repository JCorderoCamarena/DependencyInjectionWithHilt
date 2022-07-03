package com.jorgecamarena.android.client.di

import com.jorgecamarena.android.client.basicInjection.TestRepositoryInnerDependency
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

/**
 * Created by jorgecordero on Jul, 02, 2022
 **/
@Module
@InstallIn(ActivityComponent::class)
object BasicModule {

    @Provides
    fun providesInnerDependency(): TestRepositoryInnerDependency {
        return TestRepositoryInnerDependency()
    }

}