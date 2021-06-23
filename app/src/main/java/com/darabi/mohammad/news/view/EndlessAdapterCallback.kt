package com.darabi.mohammad.news.view

interface EndlessAdapterCallback <T> {

    val isEnabled: Boolean

    fun loadNextChunck()

    fun onAdapterItemClick(item: T)
}