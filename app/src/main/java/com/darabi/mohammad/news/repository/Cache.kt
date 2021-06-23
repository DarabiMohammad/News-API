package com.darabi.mohammad.news.repository

import com.darabi.mohammad.news.remote.dto.Articles
import com.darabi.mohammad.news.remote.dto.Result

interface Cache : AbstractRepository {

    suspend fun saveArticles(articles: Articles, pageNumber: Int): Result<Long>
}