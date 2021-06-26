package com.darabi.mohammad.news.ui.fragments.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.darabi.mohammad.news.databinding.FragmentArticleDetailBinding
import com.darabi.mohammad.news.remote.dto.Article
import com.darabi.mohammad.news.ui.base.BaseFragment
import javax.inject.Inject

class ArticleDetailFragment @Inject constructor() : BaseFragment() {

    private lateinit var binding: FragmentArticleDetailBinding

//    private val bundleKey = "bundle_key"
//
//    companion object {
//        fun newInstance(detail: Article): ArticleDetailFragment = ArticleDetailFragment().apply {
//            arguments = Bundle().apply { putParcelable(bundleKey, detail) }
//        }
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentArticleDetailBinding.inflate(inflater)
        return binding.root
    }
}