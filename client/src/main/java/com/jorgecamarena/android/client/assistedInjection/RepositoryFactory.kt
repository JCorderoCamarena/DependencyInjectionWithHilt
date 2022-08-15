package com.jorgecamarena.android.client.assistedInjection

import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory

/**
 * Created by jorgecordero on Aug, 14, 2022
 **/
@AssistedFactory
interface RepositoryFactory {

    fun createRepository(
        @Assisted("prod") prod: String,
        @Assisted("qa") qa: String
    ): RepositoryDemo

}