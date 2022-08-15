package com.jorgecamarena.android.client.assistedInjection

import android.util.Log
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

/**
 * Created by jorgecordero on Aug, 14, 2022
 **/
class RepositoryDemo @AssistedInject constructor(
    val repositoryClient: RepositoryClient,
    @Assisted("prod") val prodUrl: String,
    @Assisted("qa") val qaUrl: String
) {
    fun postData() {
        Log.d("Repository Demo", "client: $repositoryClient")
        Log.d("Repository Demo", "Prod url: $prodUrl")
        Log.d("Repository Demo", "QA url: $qaUrl")
    }
}

