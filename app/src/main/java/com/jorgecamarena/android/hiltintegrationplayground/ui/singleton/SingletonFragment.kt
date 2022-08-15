package com.jorgecamarena.android.hiltintegrationplayground.ui.singleton

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.jorgecamarena.android.client.singletonInstance.SingletonSampleInner
import com.jorgecamarena.android.client.singletonInstance.SingletonSampleRepo
import com.jorgecamarena.android.hiltintegrationplayground.R
import com.jorgecamarena.android.hiltintegrationplayground.databinding.FragmentSingletonBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SingletonFragment : Fragment() {
    private val TAG = SingletonFragment::class.java.simpleName

    @Inject
    lateinit var singletonSampleRepo: SingletonSampleRepo

    private var _binding: FragmentSingletonBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSingletonBinding.inflate(inflater, container, false)
        binding?.apply {
            normalBtn.setOnClickListener {
                val instance = "${useNormalInstance()}"
                normalMemReferenceLabel.text = instance.substringAfterLast('.')
            }

            singletonBtn.setOnClickListener {
                useInjectedInstance()
                val instance = "$singletonSampleRepo"
                childDependencyLabel.text = instance.substringAfterLast('.')
            }

            navigateToSecondScreenBtn.setOnClickListener {
                findNavController().navigate(R.id.singletonBFragment)
            }
        }
        return binding?.root
    }

    private fun useNormalInstance(): SingletonSampleRepo {
        val fakeSingleton = SingletonSampleRepo(SingletonSampleInner())
        fakeSingleton.doSomeStuff()
        Log.d(TAG, "useNormalInstance: $fakeSingleton")
        return fakeSingleton
    }

    private fun useInjectedInstance() {
        singletonSampleRepo.doSomeStuff()
        Log.d(TAG, "useInjectedInstance: $singletonSampleRepo")
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}