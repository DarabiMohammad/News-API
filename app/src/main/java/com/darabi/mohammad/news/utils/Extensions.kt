package com.darabi.mohammad.news.utils

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.fragment.app.Fragment

fun View.fadeIn() { if (visibility != View.VISIBLE) visibility = View.VISIBLE }

fun View.fadeOut() { if (visibility != View.GONE) visibility = View.GONE }

@SuppressLint("QueryPermissionsNeeded")
fun Fragment.openBrowser(url: String) = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
    flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
    if (resolveActivity(requireActivity().packageManager) != null) requireContext().startActivity(this)
}