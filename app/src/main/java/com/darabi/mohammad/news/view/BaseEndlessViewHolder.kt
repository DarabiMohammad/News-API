package com.darabi.mohammad.news.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseEndlessViewHolder <in M> constructor(
    private val view: View,
    private val onItemClickListener: EndlessAdapterCallback<M>?
) : RecyclerView.ViewHolder(view) {

    open fun bindModel(model: M) {
        onItemClickListener?.let { callback -> view.setOnClickListener { callback.onAdapterItemClick(model) } }
    }
}