package com.darabi.mohammad.news.ui.fragments.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.darabi.mohammad.news.MainNavGraphDirections.Companion.actionActivityToArticleDetailFragment
import com.darabi.mohammad.news.databinding.FragmentArticlesBinding
import com.darabi.mohammad.news.remote.dto.Article
import com.darabi.mohammad.news.remote.dto.Articles
import com.darabi.mohammad.news.remote.dto.Result
import com.darabi.mohammad.news.remote.dto.Status
import com.darabi.mohammad.news.ui.base.BaseFragment
import com.darabi.mohammad.news.utils.fadeIn
import com.darabi.mohammad.news.utils.fadeOut
import com.darabi.mohammad.news.view.ArticleRecyclerAdapter
import com.darabi.mohammad.news.view.EndlessAdapterCallback
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ArticlesFragment @Inject constructor() : BaseFragment(), EndlessAdapterCallback<Article>,
    Observer<Result<Articles>> {

    override val isEnabled: Boolean get() = true

    private lateinit var binding: FragmentArticlesBinding

    private val viewModel: ArticleViewModel by viewModels()
    private val adapter: ArticleRecyclerAdapter by lazy { ArticleRecyclerAdapter(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentArticlesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        viewModel.getArticles().observe(viewLifecycleOwner, this)
    }

    override fun onChanged(result: Result<Articles>) {
        when (result.status) {
            Status.LOADING -> { /* loading stuffs */ }
            Status.SUCCESS -> {
                result.result?.articles?.let {
                    if (viewModel.pageNumber > 1)
                        adapter.addSource(it)
                    else
                        adapter.setSource(it)
                }
                binding.rcvArticles.fadeIn()
                binding.prgLoading.fadeOut()
            }
            Status.ERROR -> { /* error handling must be done here */ }
        }
    }

    override fun loadNextChunck() = viewModel.getArticles().observe(viewLifecycleOwner, this)

    override fun onAdapterItemClick(item: Article) {
        findNavController().navigate(actionActivityToArticleDetailFragment(item))
    }

    private fun initView() {

        binding.rcvArticles.adapter = adapter
    }
}