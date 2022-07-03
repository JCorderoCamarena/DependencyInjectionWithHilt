package com.jorgecamarena.android.hiltintegrationplayground.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.jorgecamarena.android.client.TestRepository
import com.jorgecamarena.android.client.singletonInstance.SingletonSampleRepo
import com.jorgecamarena.android.hiltintegrationplayground.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var testRepository: TestRepository
    @Inject lateinit var singletonSampleRepo: SingletonSampleRepo

    private val backButton: Button by lazy { findViewById(R.id.open_activity_btn) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        backButton.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        testRepository.testMethod()
        singletonSampleRepo.doSomeStuff()
        Log.d("Test Singleton", "onCreate: $singletonSampleRepo")
    }
}