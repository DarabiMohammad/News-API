package com.darabi.mohammad.news.remote.dto

import android.os.Parcel
import android.os.Parcelable

data class Articles (
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)

data class Article (
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String
) //: Parcelable {

//    override fun describeContents(): Int = 0
//
//    override fun writeToParcel(dest: Parcel?, flags: Int) {
//        writeString(author)
//        writeString(title)
//        writeString(description)
//        writeString(url)
//        writeString(urlToImage)
//        writeString(publishedAt)
//        writeString(content)
//    }
//}

data class Source (val id: String?, val name: String)