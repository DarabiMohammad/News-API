package com.darabi.mohammad.news.ui.base

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.darabi.mohammad.news.databinding.ActivityMainBinding
import com.darabi.mohammad.news.ui.InteractorViewModel

abstract class BaseActivity : AppCompatActivity() {

    protected lateinit var binding: ActivityMainBinding

    protected val interactorViewModel: InteractorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}