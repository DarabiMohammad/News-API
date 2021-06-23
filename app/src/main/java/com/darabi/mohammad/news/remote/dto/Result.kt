package com.darabi.mohammad.news.remote.dto

enum class Status { SUCCESS, ERROR, LOADING }

data class Result <out T> (
    val result: T? = null,
    val status: Status,
    val throwable: Throwable? = null
) {

    companion object {

        fun <T> loading(): Result<T> = Result(status = Status.LOADING)

        fun <T> success(data: T): Result<T> = Result(data, Status.SUCCESS)

        fun <T> error(throwable: Throwable): Result<T> = Result(status = Status.ERROR, throwable = throwable)
    }
}
