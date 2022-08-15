package com.jorgecamarena.android.hiltintegrationplayground.ui.inheritance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jorgecamarena.android.hiltintegrationplayground.databinding.FragmentInheritanceBinding
import com.jorgecamarena.android.hiltintegrationplayground.utils.MySetupProvider
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class InheritanceFragment : Fragment() {
    private var _binding: FragmentInheritanceBinding? = null
    private val binding: FragmentInheritanceBinding?
        get() = _binding

    @Inject
    lateinit var setupProvider: MySetupProvider

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInheritanceBinding.inflate(inflater, container, false)
        binding?.apply {
            inheritanceLabel.text = setupProvider.useProvider()
        }
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}