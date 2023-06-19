package br.com.souzabrunoj.characterslist.presentation.ui.utils

import android.graphics.Paint
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import br.com.souzabrunoj.characterslist.R
import com.squareup.picasso.Picasso

fun ImageView.loadImage(url: String, @DrawableRes placeholderResource: Int = R.drawable.img_avatar_place_holder) {
    Picasso.get()
        .load(url)
        .placeholder(placeholderResource)
        .into(this)
}

fun TextView.underline() {
    paintFlags = paintFlags or Paint.UNDERLINE_TEXT_FLAG
}