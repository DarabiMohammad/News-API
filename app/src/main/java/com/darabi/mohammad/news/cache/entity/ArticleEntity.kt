package com.darabi.mohammad.news.cache.entity

data class ArticlesEntity (
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleEntity>
)

data class ArticleEntity (

    val source: SourceEntity,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String
)

data class SourceEntity (val id: String?, val name: String)