package com.darabi.mohammad.news.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.darabi.mohammad.news.remote.dto.Result

abstract class BaseViewModel : ViewModel() {

    protected inline fun <T> loadingLiveData(crossinline function: suspend () -> Result<T>): LiveData<Result<T>> = liveData {
        emit(Result.loading())
        emit(function())
    }
}