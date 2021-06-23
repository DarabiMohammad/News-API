package com.darabi.mohammad.news.ui

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.darabi.mohammad.news.vm.MainViewModel

abstract class BaseActivity : AppCompatActivity() {

    protected val viewModel: MainViewModel by viewModels()
}