package com.darabi.mohammad.news.ui

import android.os.Bundle
import android.os.Handler
import android.view.View
import com.darabi.mohammad.news.ui.base.BaseActivity
import com.darabi.mohammad.news.ui.fragments.BottomSheetFragment
import com.darabi.mohammad.news.ui.fragments.MainFragment
import com.darabi.mohammad.news.ui.fragments.SplashFragment
import com.darabi.mohammad.news.ui.fragments.detail.ArticleDetailFragment
import com.darabi.mohammad.news.utils.fadeIn
import com.darabi.mohammad.news.utils.fadeOut
import com.darabi.mohammad.news.utils.navigateTo
import com.google.android.material.bottomsheet.BottomSheetBehavior
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    @Inject
    internal lateinit var handler: Handler

    @Inject
    internal lateinit var splshFragment: SplashFragment

    @Inject
    internal lateinit var mainFragment: MainFragment

    @Inject
    internal lateinit var detailFragment: ArticleDetailFragment

    @Inject
    internal lateinit var bottomSheetFragment: BottomSheetFragment

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<View>

    override fun onCreate(savedInstanceState: Bundle?) {

//        supportFragmentManager.fragmentFactory = EntryPointAccessors.fromActivity(
//            this, InjectingFragmentFactoryEntryPoint::class.java
//        ).getFragmentFactory()

        super.onCreate(savedInstanceState)

        navigateTo(fragment = splshFragment, isReplace = true)
        navigateTo(binding.bottomSheetContainer.id, bottomSheetFragment)

        initViews()
        observeViewModel()
    }

    override fun onBackPressed() {
        if (bottomSheetBehavior.state != BottomSheetBehavior.STATE_HIDDEN)
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        else
            super.onBackPressed()
    }

    private fun observeViewModel() {

        interactorViewModel.onSplashFinished.observe(this, {
            navigateTo(fragment = mainFragment, isReplace = true)
        })

        interactorViewModel.onArticleClick.observe(this, {
            navigateTo(fragment = detailFragment, addToBackstack = true)
        })

        interactorViewModel.openBottomSheet.observe(this, {
            showBottomSheet()
        })
    }

    private fun initViews() {
        bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheetContainer)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        bottomSheetBehavior.addBottomSheetCallback(BottomSheetStateCallback())
    }

    private fun showBottomSheet() {
        binding.shadowView.fadeIn()

        handler.postDelayed( { bottomSheetBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED }, 150)
    }

    internal inner class BottomSheetStateCallback : BottomSheetBehavior.BottomSheetCallback() {

        override fun onStateChanged(bottomSheet: View, newState: Int) {
            if (newState == BottomSheetBehavior.STATE_HIDDEN)
                binding.shadowView.fadeOut()
        }

        override fun onSlide(bottomSheet: View, slideOffset: Float) {}
    }
}