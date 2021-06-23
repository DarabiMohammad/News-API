package com.darabi.mohammad.news.di.module

import com.darabi.mohammad.news.repository.AbstractRepository
import com.darabi.mohammad.news.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModelModule {

    @Binds
    abstract fun bindRepository(repository: Repository): AbstractRepository
}