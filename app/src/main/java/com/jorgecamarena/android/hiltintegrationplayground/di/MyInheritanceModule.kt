package com.jorgecamarena.android.hiltintegrationplayground.di

import com.jorgecamarena.android.hiltintegrationplayground.utils.MyBaseProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

/**
 * Created by jorgecordero on Aug, 14, 2022
 **/
@Module
@InstallIn(FragmentComponent::class)
class MyInheritanceModule {

    @Provides
    fun providesProvider(): MyBaseProvider {
        return MyBaseProvider()
    }
}