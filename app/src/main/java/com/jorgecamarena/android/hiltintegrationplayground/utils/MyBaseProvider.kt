package com.jorgecamarena.android.hiltintegrationplayground.utils

import android.util.Log
import com.jorgecamarena.android.client.inheritance.BaseProvider

/**
 * Created by jorgecordero on Aug, 14, 2022
 **/
class MyBaseProvider: BaseProvider() {

    override fun doWork(): String {
        Log.d("MyBaseProvider", "doWork() called")
        return MyBaseProvider::class.java.simpleName
    }

}