package com.darabi.mohammad.news.di.module

import com.darabi.mohammad.news.BuildConfig
import com.darabi.mohammad.news.remote.RemoteImple
import com.darabi.mohammad.news.remote.remoteApi.ArticlesApi
import com.darabi.mohammad.news.remote.remoteApi.RetrofitFactory
import com.darabi.mohammad.news.repository.Remote
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.logging.HttpLoggingInterceptor

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteModule {

    @Binds
    abstract fun bindRemoteImple(remoteImple: RemoteImple): Remote

    companion object {

        @Provides
        fun provideHttpLoggingInterceptor() = HttpLoggingInterceptor()

        @Provides
        fun provideMoviesService(loggingInterceptor: HttpLoggingInterceptor): ArticlesApi =
            RetrofitFactory(loggingInterceptor).makeArticlesService(BuildConfig.BASE_URL, BuildConfig.API_KEY, BuildConfig.DEBUG)
    }
}