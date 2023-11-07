package com.omidavz.countriesapp.view

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.omidavz.countriesapp.R

class BindingAdapters {

    companion object{
        @BindingAdapter("android:loadImage")
        @JvmStatic
        fun loadImage(view : ImageView, uri: String? ){
            val progressDrawable = CircularProgressDrawable(view.context).apply {
                strokeWidth = 10f
                centerRadius = 50f
                start()
            }
            val option =  RequestOptions()
                .placeholder(progressDrawable)
                .error(R.mipmap.ic_launcher_round)

            if (uri != null){
                Glide.with(view.context)
                    .setDefaultRequestOptions(option)
                    .load(uri)
                    .into(view)
            }
        }
    }
}