package com.darabi.mohammad.news.remote.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

data class Articles (
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)

@Parcelize
data class Article (
    val source: @RawValue Source,
    val author: @RawValue String,
    val title: @RawValue String,
    val description: @RawValue String,
    val url: @RawValue String,
    val urlToImage: @RawValue String?,
    val publishedAt: @RawValue String,
    val content: @RawValue String
) : Parcelable

data class Source (val id: String?, val name: String)