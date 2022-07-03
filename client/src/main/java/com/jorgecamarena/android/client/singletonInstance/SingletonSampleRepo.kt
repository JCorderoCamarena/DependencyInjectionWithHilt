package com.jorgecamarena.android.client.singletonInstance

import javax.inject.Inject

/**
 * Created by jorgecordero on Jul, 03, 2022
 **/
class SingletonSampleRepo @Inject constructor(
    private val singletonSampleInner: SingletonSampleInner
) {
    fun doSomeStuff() {
        singletonSampleInner.doSomeStuffHere()
    }
}