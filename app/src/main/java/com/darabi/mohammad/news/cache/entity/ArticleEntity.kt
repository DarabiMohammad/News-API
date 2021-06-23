package com.darabi.mohammad.news.cache.entity

data class ArticleEntity (

    val articleId: Int,
    val source: SourceEntity,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)

data class SourceEntity (val id: String?, val name: String)