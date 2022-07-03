package com.jorgecamarena.android.hiltintegrationplayground.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.jorgecamarena.android.client.singletonInstance.SingletonSampleRepo
import com.jorgecamarena.android.hiltintegrationplayground.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Created by jorgecordero on Jul, 03, 2022
 **/
@AndroidEntryPoint
class SecondActivity: AppCompatActivity() {

    @Inject lateinit var singletonSampleRepo: SingletonSampleRepo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        singletonSampleRepo.doSomeStuff()
        Log.d("Test Singleton", "onCreate: $singletonSampleRepo")
    }
}