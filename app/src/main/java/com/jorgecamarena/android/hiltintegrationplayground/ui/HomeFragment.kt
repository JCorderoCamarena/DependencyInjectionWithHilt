package com.jorgecamarena.android.hiltintegrationplayground.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.jorgecamarena.android.hiltintegrationplayground.R
import com.jorgecamarena.android.hiltintegrationplayground.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding?.apply {

            basicBtn.setOnClickListener { findNavController().navigate(R.id.basicDIFragment) }
            singletonBtn.setOnClickListener { findNavController().navigate(R.id.singletonFragment) }
            multiImplBtn.setOnClickListener { findNavController().navigate(R.id.multipleImplFragment) }

        }
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}