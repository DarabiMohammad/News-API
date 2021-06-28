package com.darabi.mohammad.news.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.darabi.mohammad.news.databinding.ActivityMainBinding
import com.darabi.mohammad.news.di.module.InjectingFragmentFactoryEntryPoint
import dagger.hilt.android.EntryPointAccessors

abstract class BaseActivity : AppCompatActivity() {

    protected lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        supportFragmentManager.fragmentFactory = EntryPointAccessors.fromActivity(
            this, InjectingFragmentFactoryEntryPoint::class.java
        ).getFragmentFactory()

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}