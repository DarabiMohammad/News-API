package com.darabi.mohammad.news.utils

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.darabi.mohammad.news.R

private fun beginTransaction(
    fragmentManager: FragmentManager, containerId: Int, fragment: Fragment, addToBackstack: Boolean, isReplace: Boolean, stateLossCommit: Boolean
): Int {
    if(fragment.isAdded) return -1
    else fragmentManager.beginTransaction().also {
        if(isReplace) {
            if(addToBackstack)
                it.addToBackStack(fragment.tag).replace(containerId, fragment, fragment.tag)
            else
                it.replace(containerId, fragment, fragment.tag)
        } else {
            if(addToBackstack)
                it.addToBackStack(fragment.tag).add(containerId, fragment, fragment.tag)
            else
                it.add(containerId, fragment, fragment.tag)
        }
    }.run { return if(stateLossCommit) this.commitAllowingStateLoss() else this.commit() }
}

fun FragmentActivity.navigateTo(
    @IdRes containerId: Int = R.id.main_framgne_container, fragment: Fragment,
    addToBackstack: Boolean = false, isReplace: Boolean = false, stateLossCommit: Boolean = false
): Int = beginTransaction(supportFragmentManager, containerId, fragment, addToBackstack, isReplace, stateLossCommit)

fun Fragment.navigateTo(
    @IdRes containerId: Int,
    fragment: Fragment,
    addToBackstack: Boolean = false,
    isReplace: Boolean = false,
    stateLossCommit: Boolean = false
): Int = beginTransaction(childFragmentManager, containerId, fragment, addToBackstack, isReplace, stateLossCommit)

fun View.fadeIn() { if (visibility != View.VISIBLE) visibility = View.VISIBLE }

fun View.fadeOut() { if (visibility != View.GONE) visibility = View.GONE }

fun View.invisible() { if (visibility != View.INVISIBLE) visibility = View.INVISIBLE }

@SuppressLint("QueryPermissionsNeeded")
fun Fragment.openBrowser(url: String) = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
    flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
    if (resolveActivity(requireActivity().packageManager) != null) requireContext().startActivity(this)
}