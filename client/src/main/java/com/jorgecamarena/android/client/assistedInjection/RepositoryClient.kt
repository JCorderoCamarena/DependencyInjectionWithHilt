package com.jorgecamarena.android.client.assistedInjection

import android.content.Context
import android.util.Log
import javax.inject.Inject

/**
 * Created by jorgecordero on Aug, 14, 2022
 **/
class RepositoryClient @Inject constructor(
    context: Context
) {
    init {
        Log.d("RepositoryClient", "init() called: context: $context")
    }
}