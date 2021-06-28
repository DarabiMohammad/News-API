package com.darabi.mohammad.news.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.darabi.mohammad.news.R
import com.darabi.mohammad.news.databinding.FragmentSplashBinding
import com.darabi.mohammad.news.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SplashFragment @Inject constructor() : BaseFragment() {

    private val splashDurationTime: Long = 3000
    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSplashBinding.inflate(inflater)
        return binding.root
    }

    override fun onResume() {
        super.onResume()

        lifecycleScope.launch {
            delay(splashDurationTime)
            findNavController().navigate(R.id.action_splashFragment_to_mainFragment)
        }
    }
}