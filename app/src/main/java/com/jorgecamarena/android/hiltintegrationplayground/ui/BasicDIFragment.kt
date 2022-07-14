package com.jorgecamarena.android.hiltintegrationplayground.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jorgecamarena.android.client.basicInjection.TestRepository
import com.jorgecamarena.android.client.basicInjection.TestRepositoryInnerDependency
import com.jorgecamarena.android.hiltintegrationplayground.databinding.FragmentBasicDiBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class BasicDIFragment : Fragment() {

    @Inject
    lateinit var testRepository: TestRepository

    private var _binding: FragmentBasicDiBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBasicDiBinding.inflate(inflater, container, false)
        binding.apply {
            normalBtn.setOnClickListener { onNormalRepositoryBtnPressed() }
            injectionBtn.setOnClickListener { onInjectedRepositoryBtnPressed() }
        }
        return binding.root
    }

    private fun onNormalRepositoryBtnPressed() {
        val repository = TestRepository(TestRepositoryInnerDependency())
        repository.testMethod()
    }

    private fun onInjectedRepositoryBtnPressed() {
        testRepository.testMethod()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}