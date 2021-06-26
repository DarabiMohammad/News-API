package com.darabi.mohammad.news.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.darabi.mohammad.news.R
import com.darabi.mohammad.news.remote.dto.Article

class ArticleViewHolder constructor(
    val itemView: View, callback: EndlessAdapterCallback<Article>
) : BaseEndlessViewHolder <Article> (itemView, callback) {

    private val articleImage = itemView.findViewById<ImageView>(R.id.img_article)
    private val title = itemView.findViewById<TextView>(R.id.txt_title)
    private val author = itemView.findViewById<TextView>(R.id.txt_author)
    private val publishedAt = itemView.findViewById<TextView>(R.id.txt_publish_date)

    private val glide = Glide.with(itemView)

    override fun bindModel(model: Article) {
        super.bindModel(model)

        glide.load(model.urlToImage).error(R.drawable.ic_baseline_terrain_24).into(articleImage)

        title.text = model.title
        author.text = model.author
        publishedAt.text = model.publishedAt
    }
}