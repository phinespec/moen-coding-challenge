package com.phinespec.moendemo.adapters

import android.os.Build
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.phinespec.moendemo.R
import com.phinespec.moendemo.model.Item
import java.time.format.DateTimeFormatter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Item>?) {
    val adapter = recyclerView.adapter as ItemListAdapter
    adapter.submitList(data)
}

@BindingAdapter("loadImage")
fun loadImage(imageView: ImageView, urlString: String?) {
    Glide
        .with(imageView.context)
        .load(urlString)
        .centerCrop()
        .placeholder(R.drawable.ic_baseline_person_24)
        .into(imageView)
}

@RequiresApi(Build.VERSION_CODES.O)
@BindingAdapter("formatDate")
fun formatDate(textView: TextView, dateString: String?) {
    if (dateString != null) {
        val dateToFormat = dateString.dropLast(10)
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val formattedDate = dateToFormat.format(formatter)
        textView.setText(formattedDate)
    }
}