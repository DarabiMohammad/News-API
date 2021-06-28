package com.darabi.mohammad.news.di.module

import com.darabi.mohammad.news.utils.factory.InjectingFragmentFactory
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@EntryPoint
@InstallIn(ActivityComponent::class)
interface InjectingFragmentFactoryEntryPoint {

    fun getFragmentFactory(): InjectingFragmentFactory
}