package com.darabi.mohammad.news.remote.remoteApi

import com.darabi.mohammad.news.remote.dto.Articles
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticlesApi {

    @GET("everything")
    suspend fun getArticles(
        @Query("q") searchWord: String,
        @Query("language") language: String,
        @Query("pageSize") pageSize: Int,
        @Query("page") pageNumber: Int
    ): Response<Articles>
}