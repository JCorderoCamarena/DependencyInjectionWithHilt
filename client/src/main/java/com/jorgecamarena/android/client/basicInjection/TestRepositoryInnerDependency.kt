package com.jorgecamarena.android.client.basicInjection

import android.util.Log

/**
 * Created by jorgecordero on Jul, 02, 2022
 */
class TestRepositoryInnerDependency {
    private val TAG = TestRepositoryInnerDependency::class.java.simpleName
    fun runSomeDummyTest() {
        for (i in 1..3) {
            Log.d(TAG, "runSomeDummyTest: $i")
        }
    }
}