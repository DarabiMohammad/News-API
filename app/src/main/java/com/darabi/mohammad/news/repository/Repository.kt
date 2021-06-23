package com.darabi.mohammad.news.repository

import com.darabi.mohammad.news.remote.dto.Articles
import com.darabi.mohammad.news.remote.dto.Result
import com.darabi.mohammad.news.remote.dto.Status
import javax.inject.Inject

class Repository @Inject constructor(
    private val remote: Remote,
    private val cache: Cache
) : AbstractRepository {

    override suspend fun getArticles(language: String, pageSize: Int, pageNumber: Int): Result<Articles> =
        cache.getArticles(language, pageSize, pageNumber).takeIf {
            it.status == Status.SUCCESS
        } ?: remote.getArticles(language, pageSize, pageNumber).also {
            it.result?.let { articles -> cache.saveArticles(articles, pageNumber) }
        }
}