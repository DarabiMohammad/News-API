package com.darabi.mohammad.news.cache

import com.darabi.mohammad.news.remote.dto.Articles
import com.darabi.mohammad.news.remote.dto.Result
import com.darabi.mohammad.news.repository.Cache
import javax.inject.Inject

class CacheImpl @Inject constructor(): Cache {

    override suspend fun getArticles(language: String, pageSize: Int, pageNumber: Int): Result<Articles> {
        TODO("Not yet implemented")
    }

    override suspend fun saveArticles() {
        TODO("Not yet implemented")
    }
}