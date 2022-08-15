package com.jorgecamarena.android.hiltintegrationplayground.ui.multipleImpl

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jorgecamarena.android.client.di.BaseFakeRepo
import com.jorgecamarena.android.client.di.ChildFakeRepo
import com.jorgecamarena.android.client.di.OtherFakeRepo
import com.jorgecamarena.android.client.multipleImplementations.MultiImplementationRepo
import com.jorgecamarena.android.hiltintegrationplayground.databinding.FragmentMultipleImplBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MultipleImplFragment : Fragment() {

    @ChildFakeRepo
    @Inject
    lateinit var childFakeRepo: MultiImplementationRepo

    @BaseFakeRepo
    @Inject
    lateinit var baseFakeRepo: MultiImplementationRepo

    @OtherFakeRepo
    @Inject
    lateinit var otherFakeRepo: MultiImplementationRepo

    private var _binding: FragmentMultipleImplBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMultipleImplBinding.inflate(inflater, container, false)
        binding?.apply {

        }
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}