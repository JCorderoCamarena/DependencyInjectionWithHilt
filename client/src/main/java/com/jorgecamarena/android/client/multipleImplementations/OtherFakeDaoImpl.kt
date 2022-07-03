package com.jorgecamarena.android.client.multipleImplementations

import android.util.Log

/**
 * Created by jorgecordero on Jul, 03, 2022
 **/
class OtherFakeDaoImpl: FakeDao {
    private val TAG = OtherFakeDaoImpl::class.java.simpleName
    override fun runSomeMethod() {
        for (i in 1..3) Log.d(TAG, "runSomeMethod: $i")
    }
}