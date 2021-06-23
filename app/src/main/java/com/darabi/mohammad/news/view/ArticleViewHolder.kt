package com.darabi.mohammad.news.view

import android.view.View
import com.darabi.mohammad.news.remote.dto.Article

class ArticleViewHolder constructor(
    val itemView: View, callback: EndlessAdapterCallback<Article>
) : BaseEndlessViewHolder <Article> (itemView, callback) {

    override fun bindModel(model: Article) {
        super.bindModel(model)
    }
}