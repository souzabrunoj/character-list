package br.com.souzabrunoj.characterslist.ui.utils

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String, @DrawableRes placeholderResource: Int = 0) {
    Glide.with(this)
        .load(url)
        .fitCenter()
        .placeholder(placeholderResource)
        .into(this)
}