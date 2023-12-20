package com.sparklead.cryptosync.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.sparklead.cryptosync.R
import java.io.IOException

class GlideLoader(private val context: Context) {

    fun loadAnimePicture(image: Any, imageView: ImageView) {
        try {
            Glide
                .with(context)
                .load(image)
                .placeholder(R.drawable.blank)
                .into(imageView)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

}