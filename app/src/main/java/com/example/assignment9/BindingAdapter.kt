package com.example.assignment9

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignment9.flag.FlagAdapter
import com.example.assignment9.network.Countries
import com.example.assignment9.network.CountriesContainer

@BindingAdapter("imgUrl")
fun bindImage(imgView : ImageView, imgUrl : String?)    {
    imgUrl?.let {
        val imgUri = it.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .into(imgView)
    }
}
