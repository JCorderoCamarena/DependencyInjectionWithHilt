package com.jorgecamarena.android.hiltintegrationplayground.ui.assistedInjection

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jorgecamarena.android.client.assistedInjection.RepositoryFactory
import com.jorgecamarena.android.hiltintegrationplayground.databinding.FragmentAssistedInjectionBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AssistedInjectionFragment : Fragment() {

    private var _binding: FragmentAssistedInjectionBinding? = null
    private val binding get() = _binding

    @Inject
    lateinit var repositoryFactory: RepositoryFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAssistedInjectionBinding.inflate(inflater, container, false)
        binding?.apply {
            val repoDemo = repositoryFactory.createRepository("http://www.prod.com", "http://www.qa.com")
            prodLabel.text = "Prod: ${repoDemo.prodUrl}"
            qaLabel.text = "QA: ${repoDemo.qaUrl}"
            repoDemo.postData()
        }
        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}