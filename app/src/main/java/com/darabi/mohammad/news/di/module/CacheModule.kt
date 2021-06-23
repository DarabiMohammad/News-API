package com.darabi.mohammad.news.di.module

import android.content.Context
import com.darabi.mohammad.news.cache.CacheImpl
import com.darabi.mohammad.news.cache.db.ArticlesDatabase
import com.darabi.mohammad.news.repository.Cache
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CacheModule {

    @Binds
    abstract fun bindCacheImple(cacheImpl: CacheImpl): Cache

    companion object {

        @Provides
        fun provideGson(): Gson = Gson()

        @Provides
        fun provideDatabase(@ApplicationContext appContext: Context): ArticlesDatabase = ArticlesDatabase.getInstance(appContext)
    }
}