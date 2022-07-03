package com.jorgecamarena.android.client.di

import com.jorgecamarena.android.client.multipleImplementations.BaseFakeDaoImpl
import com.jorgecamarena.android.client.multipleImplementations.ChildBaseFakeDaoImpl
import com.jorgecamarena.android.client.multipleImplementations.MultiImplementationRepo
import com.jorgecamarena.android.client.multipleImplementations.OtherFakeDaoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Qualifier

/**
 * Created by jorgecordero on Jul, 03, 2022
 **/
@Module
@InstallIn(ActivityComponent::class)
object MultipleImplementationModule {

    @ChildFakeRepo
    @Provides
    fun providesChildFakeRepo() = MultiImplementationRepo(
        ChildBaseFakeDaoImpl()
    )

    @BaseFakeRepo
    @Provides
    fun providesBaseFakeRepo() = MultiImplementationRepo(
        BaseFakeDaoImpl()
    )

    @OtherFakeRepo
    @Provides
    fun providesOtherFakeRepo() = MultiImplementationRepo(
        OtherFakeDaoImpl()
    )

}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ChildFakeRepo

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BaseFakeRepo

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class OtherFakeRepo