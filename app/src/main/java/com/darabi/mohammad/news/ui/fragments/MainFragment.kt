package com.darabi.mohammad.news.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.darabi.mohammad.news.R
import com.darabi.mohammad.news.databinding.FragmentMainBinding
import com.darabi.mohammad.news.ui.base.BaseFragment
import com.darabi.mohammad.news.ui.fragments.article.ArticlesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment @Inject constructor(
    private val articlesFragment: ArticlesFragment,
    private val profileFragment: ProfileFragment,
) : BaseFragment(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        binding.viewPager.currentItem = if (item.itemId == R.id.item_article) 0 else 1
        return true
    }

    private fun initViews() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener(this)
        binding.viewPager.adapter = PagerAdapter()
    }

    internal inner class PagerAdapter : FragmentStateAdapter(childFragmentManager, lifecycle) {

        override fun getItemCount(): Int = 2

        override fun createFragment(position: Int): Fragment = when (position) {
            0 -> articlesFragment
            else -> profileFragment
        }
    }
}