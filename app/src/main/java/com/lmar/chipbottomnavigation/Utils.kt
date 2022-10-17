package com.lmar.chipbottomnavigation

import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.core.graphics.drawable.DrawableCompat

class Utils {
    fun setTint(d: Drawable?, color: Int): Drawable? {
        val wrappedDrawable = DrawableCompat.wrap(d!!)
        DrawableCompat.setTint(wrappedDrawable, color)
        return wrappedDrawable
    }
    fun setTint(d: Drawable?, color: String): Drawable? {
        val color = Color.parseColor(color)
        val wrappedDrawable = DrawableCompat.wrap(d!!)
        DrawableCompat.setTint(wrappedDrawable, color)
        return wrappedDrawable
    }
}