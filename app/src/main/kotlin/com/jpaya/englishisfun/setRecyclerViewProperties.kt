package com.jpaya.englishisfun

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.ShimmerFrameLayout
import com.jpaya.englishisfun.abbreviations.ui.adapter.AbbreviationsAdapter
import com.jpaya.englishisfun.abbreviations.ui.model.AbbreviationItem
import com.jpaya.englishisfun.extensions.hide
import com.jpaya.englishisfun.extensions.show

@BindingAdapter("list")
fun <T> setRecyclerViewData(recyclerView: RecyclerView, data: List<T>) {
    (recyclerView.adapter as AbbreviationsAdapter).submitList(data as List<AbbreviationItem>)
}

@BindingAdapter("visible")
fun setShimmerFrameLayoutVisible(view: ShimmerFrameLayout, visible: Boolean) = if (visible) {
    view.show()
} else {
    view.hide()
}
