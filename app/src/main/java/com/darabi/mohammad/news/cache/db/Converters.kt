package com.darabi.mohammad.news.cache.db

import androidx.room.TypeConverter
import com.darabi.mohammad.news.cache.entity.ArticleEntity
import java.lang.reflect.Type
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class Converters @Inject constructor() {

    @Inject
    internal lateinit var gson: Gson

    @TypeConverter
    fun fromString(string: String): List<ArticleEntity> = gson.fromJson(string, getType<List<ArticleEntity>>())

    @TypeConverter
    fun toString(list: List<ArticleEntity>): String = gson.toJson(list, getType<List<ArticleEntity>>())
}

inline fun <reified T> getType(): Type = object : TypeToken<T>() {}.type