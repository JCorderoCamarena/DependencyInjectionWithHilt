package com.jorgecamarena.android.hiltintegrationplayground.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jorgecamarena.android.client.TestRepository
import com.jorgecamarena.android.client.singletonInstance.SingletonSampleRepo
import com.jorgecamarena.android.hiltintegrationplayground.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var testRepository: TestRepository
    @Inject lateinit var singletonSampleRepo: SingletonSampleRepo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testRepository.testMethod()
    }
}