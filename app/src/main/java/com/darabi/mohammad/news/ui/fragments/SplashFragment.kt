package com.darabi.mohammad.news.ui.fragments

import androidx.lifecycle.lifecycleScope
import com.darabi.mohammad.news.ui.base.BaseFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashFragment @Inject constructor() : BaseFragment() {

    private val splashDurationTime: Long = 3000

    override fun onResume() {
        super.onResume()

        lifecycleScope.launch {
            delay(splashDurationTime)
            interactorViewModel.onSplashFinished.value = true
        }
    }
}