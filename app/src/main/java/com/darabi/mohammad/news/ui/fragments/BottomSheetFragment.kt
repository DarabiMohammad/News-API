package com.darabi.mohammad.news.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.darabi.mohammad.news.databinding.FragmentBottomSheetBinding
import com.darabi.mohammad.news.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BottomSheetFragment @Inject constructor() : BaseFragment() {

    internal lateinit var binding: FragmentBottomSheetBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentBottomSheetBinding.inflate(inflater)
        return binding.root
    }
}