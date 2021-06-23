package com.darabi.mohammad.news.cache.mapper

import com.darabi.mohammad.news.cache.entity.ArticleEntity
import com.darabi.mohammad.news.cache.entity.ArticlesEntity
import com.darabi.mohammad.news.cache.entity.SourceEntity
import com.darabi.mohammad.news.remote.dto.Article
import com.darabi.mohammad.news.remote.dto.Articles
import com.darabi.mohammad.news.remote.dto.Source
import javax.inject.Inject

class CacheMapper @Inject constructor() {

    fun mapFormEntity(entity: ArticlesEntity): Articles = Articles(
        entity.status,
        entity.totalResults,
        fromEntityList(entity.articles)
    )

    fun mapToEntity(articles: Articles): ArticlesEntity = ArticlesEntity(
        articles.status,
        articles.totalResults,
        toEntityList(articles.articles)
    )

    private fun toEntityList(articles: List<Article>): List<ArticleEntity> = articles.map {
        ArticleEntity(
            SourceEntity(it.source.id, it.source.name),
            it.author,
            it.title,
            it.description,
            it.url,
            it.urlToImage,
            it.publishedAt,
            it.content
        )
    }

    private fun fromEntityList(entity: List<ArticleEntity>): List<Article> = entity.map {
        Article(
            Source(it.source.id, it.source.name),
            it.author,
            it.title,
            it.description,
            it.url,
            it.urlToImage,
            it.publishedAt,
            it.content
        )
    }
}