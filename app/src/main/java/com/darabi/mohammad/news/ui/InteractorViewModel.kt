package com.darabi.mohammad.news.ui

import androidx.lifecycle.MutableLiveData
import com.darabi.mohammad.news.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InteractorViewModel @Inject constructor() : BaseViewModel() {

    val onSplashFinished by lazy { MutableLiveData<Boolean>() }
}