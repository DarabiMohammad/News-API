package com.darabi.mohammad.news.ui

import android.os.Bundle
import com.darabi.mohammad.news.ui.base.BaseActivity
import com.darabi.mohammad.news.ui.fragments.MainFragment
import com.darabi.mohammad.news.ui.fragments.SplashFragment
import com.darabi.mohammad.news.utils.navigateTo
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    @Inject
    internal lateinit var splshFragment: SplashFragment

    @Inject
    internal lateinit var mainFragment: MainFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navigateTo(fragment = splshFragment, isReplace = true)

        observeViewModel()
    }

    private fun observeViewModel() {

        interactorViewModel.onSplashFinished.observe(this, {
            navigateTo(fragment = mainFragment, isReplace = true)
        })
    }
}