package com.darabi.mohammad.news.utils

import com.darabi.mohammad.news.remote.dto.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

suspend inline fun <T> safeApiCall(crossinline apiService: suspend () -> Response<T>): Result<T> = try {
    withContext(Dispatchers.IO) { Result.success(data = apiService().body()!!) }
} catch (error: Exception) {
    withContext(Dispatchers.Main) { error(error) }
}

suspend inline fun <T> safeDatabaseCall(crossinline databaseCall: suspend () -> T): Result<T> = try {
    withContext(Dispatchers.IO) { Result.success(data = databaseCall()!!) }
} catch (error: Exception) {
    withContext(Dispatchers.Main) { error(error) }
}