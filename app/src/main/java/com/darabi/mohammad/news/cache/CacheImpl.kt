package com.darabi.mohammad.news.cache

import com.darabi.mohammad.news.cache.dao.ArticlesDao
import com.darabi.mohammad.news.cache.db.ArticlesDatabase
import com.darabi.mohammad.news.cache.entity.PageEntity
import com.darabi.mohammad.news.cache.mapper.CacheMapper
import com.darabi.mohammad.news.remote.dto.Articles
import com.darabi.mohammad.news.remote.dto.Result
import com.darabi.mohammad.news.repository.Cache
import com.darabi.mohammad.news.utils.safeDatabaseCall
import javax.inject.Inject

class CacheImpl @Inject constructor(
    private val database: ArticlesDatabase,
    private val mapper: CacheMapper
): Cache {

    private val dao: ArticlesDao by lazy { database.getNewsDao() }

    /**
     * at this point, some parameters are not in use. unused parameters:
     *
     * @param searchWord
     * @param language
     * @param pageSize
     */
    override suspend fun getArticles(
        searchWord: String, language: String, pageSize: Int, pageNumber: Int
    ): Result<Articles> = safeDatabaseCall {
        mapper.mapFormEntity(dao.getArticlesByPageNumber(pageNumber)!!.articles)
    }

    override suspend fun saveArticles(articles: Articles, pageNumber: Int): Result<Long> = safeDatabaseCall {
        dao.insertNewArticles(PageEntity(pageNumber, mapper.mapToEntity(articles)))
    }
}