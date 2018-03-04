package zakharvoit.com.foodhackapp.common

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun setGoodFullScreenImage(imageView: ImageView, context: Context, url: String) {
    Glide.with(context)
            .load(url)
            .apply(RequestOptions()
                    .override(imageView.width, imageView.height)
                    .centerCrop())
            .into(imageView)
}