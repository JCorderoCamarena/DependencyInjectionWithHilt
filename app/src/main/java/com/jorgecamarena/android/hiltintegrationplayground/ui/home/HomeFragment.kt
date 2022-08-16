package com.jorgecamarena.android.hiltintegrationplayground.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.jorgecamarena.android.hiltintegrationplayground.R
import com.jorgecamarena.android.hiltintegrationplayground.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding

    private val options = listOf(
        HomeItem("Basic", R.id.basicDIFragment),
        HomeItem("Singleton", R.id.singletonBFragment),
        HomeItem("Multiple Impl", R.id.multipleImplFragment),
        HomeItem("Assisted Impl", R.id.assistedInjectionFragment),
        HomeItem("Inheritance", R.id.inheritanceFragment)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding?.apply {
            itemsRecyclerView.layoutManager = GridLayoutManager(context, 4)
            itemsRecyclerView.adapter = HomeAdapter(options) {
                findNavController().navigate(it.destinationId)
            }
        }

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}