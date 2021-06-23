package com.darabi.mohammad.news.cache.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.darabi.mohammad.news.cache.DB_NAME
import com.darabi.mohammad.news.cache.DB_VERSION
import com.darabi.mohammad.news.cache.dao.ArticlesDao
import com.darabi.mohammad.news.cache.entity.PageEntity

@Database(
    entities = [
        PageEntity::class
    ], version = DB_VERSION, exportSchema = false
)
@TypeConverters(value = [Converters::class])
abstract class ArticlesDatabase : RoomDatabase() {

    abstract fun getNewsDao(): ArticlesDao

    companion object {

        @Volatile
        private var instance: ArticlesDatabase? = null

        fun getInstance(context: Context): ArticlesDatabase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    ArticlesDatabase::class.java,
                    DB_NAME
                ).build().also { instance = it }
            }
    }
}