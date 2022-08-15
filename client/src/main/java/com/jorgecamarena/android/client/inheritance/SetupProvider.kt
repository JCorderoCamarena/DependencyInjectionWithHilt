package com.jorgecamarena.android.client.inheritance

import javax.inject.Inject

/**
 * Created by jorgecordero on Aug, 14, 2022
 */
open class SetupProvider @Inject constructor(
    open val baseProvider: BaseProvider
) {
    fun useProvider(): String {
        return baseProvider.doWork()
    }
}