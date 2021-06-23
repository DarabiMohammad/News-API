package com.darabi.mohammad.news.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.darabi.mohammad.news.remote.dto.Result
import com.darabi.mohammad.news.remote.dto.Result.Companion.loading
import com.darabi.mohammad.news.repository.AbstractRepository
import com.darabi.mohammad.news.utils.PAGING_SIZE
import com.darabi.mohammad.news.utils.enums.Language
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: AbstractRepository
) : ViewModel() {

    fun getArticles(pageNumber: Int) = loadingLiveData {
        repository.getArticles(Language.English.code, PAGING_SIZE, pageNumber)
    }

    private inline fun <T> loadingLiveData(crossinline function: suspend () -> Result<T>): LiveData<Result<T>> = liveData {
        emit(loading())
        emit(function())
    }
}