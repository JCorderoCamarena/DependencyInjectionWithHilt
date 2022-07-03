package com.jorgecamarena.android.client.multipleImplementations

import android.util.Log

/**
 * Created by jorgecordero on Jul, 03, 2022
 **/
open class BaseFakeDaoImpl: FakeDao {
    private val TAG = BaseFakeDaoImpl::class.java.simpleName
    override fun runSomeMethod() {
        for (i in 1..3) Log.d(TAG, "runSomeMethod: $i")
    }
}