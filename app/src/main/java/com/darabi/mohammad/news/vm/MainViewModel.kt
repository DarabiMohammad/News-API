package com.darabi.mohammad.news.vm

import androidx.lifecycle.ViewModel
import com.darabi.mohammad.news.repository.AbstractRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: AbstractRepository
) : ViewModel() {
}