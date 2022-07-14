package com.jorgecamarena.android.hiltintegrationplayground.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jorgecamarena.android.client.singletonInstance.SingletonSampleInner
import com.jorgecamarena.android.client.singletonInstance.SingletonSampleRepo
import com.jorgecamarena.android.hiltintegrationplayground.databinding.FragmentSingletonBBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SingletonBFragment : Fragment() {
    private val TAG = SingletonBFragment::class.java.simpleName

    @Inject
    lateinit var singletonSampleRepo: SingletonSampleRepo

    private var _binding: FragmentSingletonBBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSingletonBBinding.inflate(inflater, container, false)
        binding?.apply {
            normalMemReferenceLabel.text = getNormalMemoryReference()
            hiltMemReferenceLabel.text = getInjectedMemoryReference()
        }
        return binding?.root
    }

    private fun getNormalMemoryReference(): String {
        val fakeSingleton = SingletonSampleRepo(SingletonSampleInner())
        return "$fakeSingleton".substringAfterLast('.')
    }

    private fun getInjectedMemoryReference(): String {
        return "$singletonSampleRepo".substringAfterLast('.')
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}