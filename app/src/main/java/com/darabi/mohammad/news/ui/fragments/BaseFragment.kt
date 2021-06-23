package com.darabi.mohammad.news.ui.fragments

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment constructor(@LayoutRes private val layoutRes: Int) : Fragment(layoutRes) {
}