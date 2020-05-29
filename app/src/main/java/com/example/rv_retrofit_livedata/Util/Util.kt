package com.example.rv_retrofit_livedata.Util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.rv_retrofit_livedata.R

fun ImageView.loadImage(uri: String?) {
    val options = RequestOptions()
        .placeholder(android.R.drawable.stat_sys_download)
        .circleCrop()
        .error(R.mipmap.ic_launcher_round)
    Glide.with(this.context)
        .setDefaultRequestOptions(options)
        .load(uri)
        .into(this)
}