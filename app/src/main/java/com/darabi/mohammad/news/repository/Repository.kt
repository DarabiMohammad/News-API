package com.darabi.mohammad.news.repository

import com.darabi.mohammad.news.remote.dto.Articles
import com.darabi.mohammad.news.remote.dto.Result
import com.darabi.mohammad.news.remote.dto.Status
import java.lang.Exception
import javax.inject.Inject

class Repository @Inject constructor(
    private val remote: Remote,
    private val cache: Cache
) : AbstractRepository {

    override suspend fun getArticles(searchWord: String, language: String, pageSize: Int, pageNumber: Int): Result<Articles> = try {
        cache.getArticles(searchWord, language, pageSize, pageNumber)
    } catch (exception: Exception) {
        remote.getArticles(searchWord, language, pageSize, pageNumber).also {
            it.result?.let { articles -> cache.saveArticles(articles, pageNumber) }
        }
    }
}