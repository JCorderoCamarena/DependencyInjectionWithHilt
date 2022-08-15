package com.jorgecamarena.android.client.di

import com.jorgecamarena.android.client.inheritance.BaseProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

/**
 * Created by jorgecordero on Aug, 14, 2022
 **/
@Module
@InstallIn(FragmentComponent::class)
open class InheritanceModule {

    @Provides
    open fun providesProvider() = BaseProvider()

}