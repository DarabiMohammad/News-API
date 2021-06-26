package com.darabi.mohammad.news.cache.db

import androidx.room.TypeConverter
import com.darabi.mohammad.news.cache.entity.ArticlesEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import javax.inject.Inject

class Converters @Inject constructor() {

    private val gson: Gson by lazy { Gson() }

    @TypeConverter
    fun fromString(string: String): ArticlesEntity = gson.fromJson(string, getType<ArticlesEntity>())

    @TypeConverter
    fun toString(articlesEntity: ArticlesEntity): String = gson.toJson(articlesEntity, getType<ArticlesEntity>())

    private inline fun <reified T> getType(): Type = object : TypeToken<T>() {}.type
}