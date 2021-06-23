package com.darabi.mohammad.news.ui

import android.os.Bundle
import com.darabi.mohammad.news.R
import com.darabi.mohammad.news.remote.dto.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getArticles(1).observe(this, {
            when (it.status) {
                Status.LOADING -> {
                    val sd = it.status
                }
                Status.SUCCESS -> {
                    val ds = it.result
                }
                Status.ERROR -> {
                    val sdf = it.throwable
                }
            }
        })
    }
}