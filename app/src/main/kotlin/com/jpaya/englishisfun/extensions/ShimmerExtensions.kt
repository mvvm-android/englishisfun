package com.jpaya.englishisfun.extensions

import androidx.core.view.isVisible
import com.facebook.shimmer.ShimmerFrameLayout

/**
 *  Shows and starts the animation effect on a ShimmerFrameLayout.
 */
fun ShimmerFrameLayout.show() {
    isVisible = true
    startShimmer()
}

/**
 *  Hides and stops the animation effect on a ShimmerFrameLayout.
 */
fun ShimmerFrameLayout.hide() {
    isVisible = false
    stopShimmer()
}
