package com.jorgecamarena.android.hiltintegrationplayground.utils

import com.jorgecamarena.android.client.inheritance.SetupProvider
import javax.inject.Inject

/**
 * Created by jorgecordero on Aug, 15, 2022
 **/
class MySetupProvider @Inject constructor(
    override val baseProvider: MyBaseProvider
): SetupProvider(baseProvider) {

}