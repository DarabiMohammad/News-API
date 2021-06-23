package com.darabi.mohammad.news.cache.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.darabi.mohammad.news.cache.*

@Entity(tableName = PAGE_TABLE)
data class PageEntity(

    @PrimaryKey
    @ColumnInfo(name = PAGE_NUMBER)
    val pageNumber: Int,
    val articles: List<ArticleEntity>
)