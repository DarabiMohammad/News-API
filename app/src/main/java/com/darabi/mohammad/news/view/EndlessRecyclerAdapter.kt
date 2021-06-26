package com.darabi.mohammad.news.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class EndlessRecyclerAdapter <O, VH: BaseEndlessViewHolder<O>> : RecyclerView.Adapter<VH>() {

    internal abstract fun getLoadingViewHolder(parent: ViewGroup): VH
    internal abstract fun getNormalViewHolder(parent: ViewGroup): VH

    private val normalViewType = 0
    private val loadingViewType = 1
    private var isLastChunk: Boolean = false
    protected abstract val callback: EndlessAdapterCallback<O>

    private val objects = arrayListOf<O?>()

    override fun getItemViewType(position: Int): Int =
        if (objects[position] == null) loadingViewType else normalViewType

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH =
        if (viewType == normalViewType) getNormalViewHolder(parent) else getLoadingViewHolder(parent)

    override fun onBindViewHolder(holder: VH, position: Int) {
        objects[position]?.let { holder.bindModel(it) }
    }

    override fun getItemCount(): Int = objects.size

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (!recyclerView.canScrollVertically(-1) || !callback.isEnabled)
                    return
                else if (!recyclerView.canScrollVertically(1) && !isLastChunk)
                    callback.loadNextChunck()
            }
        })
    }

    protected fun inflateLayout(view: ViewGroup, @LayoutRes layout: Int): View =
        LayoutInflater.from(view.context).inflate(layout, view, false)

    open fun setSource(source: List<O>) {
        isLastChunk = false
        objects.clear().also { notifyDataSetChanged() }
        objects.addAll(source)
        if (callback.isEnabled && source.size > 19) objects.add(null)
        notifyItemRangeChanged(objects.size -1, source.size)
    }

    fun addSource(source: List<O>) {
        val lastIndex = objects.size - 1
        if (source.isEmpty() && callback.isEnabled) {
            isLastChunk = true
            objects.remove(null)
            notifyItemRemoved(lastIndex)
        } else {
            objects.addAll(lastIndex, source)
            notifyItemRangeInserted(lastIndex, source.size)
        }
    }
}