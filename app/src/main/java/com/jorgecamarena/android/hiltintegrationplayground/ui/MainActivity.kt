package com.jorgecamarena.android.hiltintegrationplayground.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.jorgecamarena.android.client.basicInjection.TestRepository
import com.jorgecamarena.android.client.basicInjection.TestRepositoryInnerDependency
import com.jorgecamarena.android.client.multipleImplementations.BaseFakeDaoImpl
import com.jorgecamarena.android.client.multipleImplementations.ChildBaseFakeDaoImpl
import com.jorgecamarena.android.client.multipleImplementations.MultiImplementationRepo
import com.jorgecamarena.android.client.multipleImplementations.OtherFakeDaoImpl
import com.jorgecamarena.android.client.singletonInstance.SingletonSampleInner
import com.jorgecamarena.android.client.singletonInstance.SingletonSampleRepo
import com.jorgecamarena.android.hiltintegrationplayground.R

class MainActivity : AppCompatActivity() {

    lateinit var testRepository: TestRepository
    lateinit var singletonSampleRepo: SingletonSampleRepo

    lateinit var childFakeRepo: MultiImplementationRepo
    lateinit var baseFakeRepo: MultiImplementationRepo
    lateinit var otherFakeRepo: MultiImplementationRepo

    private val backButton: Button by lazy { findViewById(R.id.open_activity_btn) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        backButton.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
        testRepository = TestRepository(TestRepositoryInnerDependency())
        testRepository.testMethod()

        singletonSampleRepo = SingletonSampleRepo(SingletonSampleInner())
        singletonSampleRepo.doSomeStuff()

        childFakeRepo = MultiImplementationRepo(ChildBaseFakeDaoImpl())
        baseFakeRepo = MultiImplementationRepo(BaseFakeDaoImpl())
        otherFakeRepo = MultiImplementationRepo(OtherFakeDaoImpl())

        childFakeRepo.runSomeStuff()
        baseFakeRepo.runSomeStuff()
        otherFakeRepo.runSomeStuff()
        Log.d("Test Singleton", "onCreate: $singletonSampleRepo")
    }
}