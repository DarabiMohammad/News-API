package com.darabi.mohammad.news.ui.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.darabi.mohammad.news.ui.InteractorViewModel

abstract class BaseFragment : Fragment() {

    val fragmentTag: String get() = this.javaClass.simpleName

    protected val interactorViewModel: InteractorViewModel by viewModels( { requireActivity() } )
}