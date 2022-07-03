package com.jorgecamarena.android.client.singletonInstance

import android.util.Log

/**
 * Created by jorgecordero on Jul, 03, 2022
 **/
class SingletonSampleInner {
    private val TAG = SingletonSampleInner::class.java.simpleName

    fun doSomeStuffHere() {
        for (i in 1..5) Log.d(TAG, "doSomeStuffHere: $i")
    }
}