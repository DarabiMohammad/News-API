package com.darabi.mohammad.news.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.darabi.mohammad.news.databinding.FragmentArticleDetailBinding
import com.darabi.mohammad.news.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ArticleDetailFragment @Inject constructor() : BaseFragment() {

    private lateinit var binding: FragmentArticleDetailBinding

    private val args: ArticleDetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentArticleDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {
        args.article.run {
            binding.txtTitle.text = this.title
            binding.txtAuthor.text = this.author
        }
    }
}