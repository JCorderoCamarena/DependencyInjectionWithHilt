package com.jorgecamarena.android.hiltintegrationplayground.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.jorgecamarena.android.client.singletonInstance.SingletonSampleInner
import com.jorgecamarena.android.client.singletonInstance.SingletonSampleRepo
import com.jorgecamarena.android.hiltintegrationplayground.R

/**
 * Created by jorgecordero on Jul, 03, 2022
 **/
class SecondActivity: AppCompatActivity() {

    lateinit var singletonSampleRepo: SingletonSampleRepo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        singletonSampleRepo = SingletonSampleRepo(SingletonSampleInner())
        singletonSampleRepo.doSomeStuff()
        Log.d("Test Singleton", "onCreate: $singletonSampleRepo")
    }
}