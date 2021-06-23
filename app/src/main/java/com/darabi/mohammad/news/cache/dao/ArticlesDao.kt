package com.darabi.mohammad.news.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.darabi.mohammad.news.cache.entity.PageEntity

@Dao
interface ArticlesDao {

    @Query("SELECT * FROM page_table WHERE page_number = :pageNumber")
    suspend fun getArticlesByPageNumber(pageNumber: Int): PageEntity?

    @Insert(entity = PageEntity::class, onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNewArticles(pageEntity: PageEntity): Long
}