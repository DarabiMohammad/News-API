package com.darabi.mohammad.news.remote

import com.darabi.mohammad.news.remote.dto.Articles
import com.darabi.mohammad.news.remote.dto.Result
import com.darabi.mohammad.news.remote.remoteApi.ArticlesApi
import com.darabi.mohammad.news.repository.Remote
import com.darabi.mohammad.news.utils.safeApiCall
import javax.inject.Inject

class RemoteImple @Inject constructor(
    private val apiService: ArticlesApi
) : Remote {

    // todo : hard coded function.
    override suspend fun getArticles(language: String, pageSize: Int, pageNumber: Int): Result<Articles> = safeApiCall {
        apiService.getArticles("bitcoin", language, pageSize, pageNumber)
    }
}