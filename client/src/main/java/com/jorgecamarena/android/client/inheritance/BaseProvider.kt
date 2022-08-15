package com.jorgecamarena.android.client.inheritance

import android.util.Log

/**
 * Created by jorgecordero on Aug, 14, 2022
 **/
open class BaseProvider {
    init {
        Log.d("BaseProvider", "init() called")
    }

    open fun doWork(): String {
        Log.d("BaseProvider", "doWork() called")
        return BaseProvider::class.java.simpleName
    }
}