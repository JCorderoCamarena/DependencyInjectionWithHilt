package com.jorgecamarena.android.hiltintegrationplayground.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.jorgecamarena.android.client.basicInjection.TestRepository
import com.jorgecamarena.android.client.di.BaseFakeRepo
import com.jorgecamarena.android.client.di.ChildFakeRepo
import com.jorgecamarena.android.client.di.OtherFakeRepo
import com.jorgecamarena.android.client.multipleImplementations.MultiImplementationRepo
import com.jorgecamarena.android.client.singletonInstance.SingletonSampleRepo
import com.jorgecamarena.android.hiltintegrationplayground.R
import com.jorgecamarena.android.hiltintegrationplayground.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val backVisible = when(destination.id) {
                R.id.homeFragment -> false
                else -> true
            }
            supportActionBar?.setDisplayHomeAsUpEnabled(backVisible)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            android.R.id.home -> navController.popBackStack()
            else -> super.onOptionsItemSelected(item)
        }
    }
}