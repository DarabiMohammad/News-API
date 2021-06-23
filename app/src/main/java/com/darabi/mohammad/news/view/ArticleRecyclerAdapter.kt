package com.darabi.mohammad.news.view

import android.view.ViewGroup
import com.darabi.mohammad.news.R
import com.darabi.mohammad.news.remote.dto.Article

class ArticleRecyclerAdapter constructor(
    private val adapterCallback: EndlessAdapterCallback<Article>
) : EndlessRecyclerAdapter <Article, BaseEndlessViewHolder<Article>>() {

    override val callback: EndlessAdapterCallback<Article> get() = adapterCallback

    override fun getLoadingViewHolder(parent: ViewGroup): BaseEndlessViewHolder<Article> =
        BaseLoadingViewHolder(inflateLayout(parent, R.layout.rcv_item_loading))

    override fun getNormalViewHolder(parent: ViewGroup): BaseEndlessViewHolder<Article> =
        ArticleViewHolder(inflateLayout(parent, R.layout.rcv_item_article_content), adapterCallback)
}