package com.darabi.mohammad.news.repository

import com.darabi.mohammad.news.remote.dto.Articles
import com.darabi.mohammad.news.remote.dto.Result

interface AbstractRepository {

//    val context: Context

    suspend fun getArticles(language: String, pageSize: Int, pageNumber: Int): Result<Articles>

    suspend fun saveArticles()
}