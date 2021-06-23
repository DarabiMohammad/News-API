package com.darabi.mohammad.news.remote.remoteApi

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class RetrofitFactory @Inject constructor(
    private val loggingInterceptor: HttpLoggingInterceptor,
    private val interceptor: RetrofitInterceptor
) {

    private val timeOut = 60L

    fun makeArticlesService(baseUrl: String, isDebugMode: Boolean): ArticlesApi =
        makeNewsService(baseUrl, makeOkHttpClient(makeLoggingInterceptor(isDebugMode)))

    private fun makeNewsService(baseUrl: String, okHttpClient: OkHttpClient): ArticlesApi =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ArticlesApi::class.java)

    private fun makeOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(timeOut, TimeUnit.SECONDS)
            .readTimeout(timeOut, TimeUnit.SECONDS).build()

    private fun makeLoggingInterceptor(isDebugMode: Boolean): HttpLoggingInterceptor {
        val logger = loggingInterceptor
        logger.level =
            if (isDebugMode) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return logger
    }
}