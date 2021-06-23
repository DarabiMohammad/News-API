package com.darabi.mohammad.news.repository

import android.content.Context
import com.darabi.mohammad.news.remote.dto.Articles
import com.darabi.mohammad.news.remote.dto.Result
import javax.inject.Inject

class Repository @Inject constructor(
//    private val mContext: Context,
    private val remote: Remote,
    private val cache: Cache
) : AbstractRepository {

//    override val context: Context get() = mContext

    override suspend fun getArticles(language: String, pageSize: Int, pageNumber: Int): Result<Articles> {
        TODO("Not yet implemented")
    }

    override suspend fun saveArticles() {
        TODO("Not yet implemented")
    }
}