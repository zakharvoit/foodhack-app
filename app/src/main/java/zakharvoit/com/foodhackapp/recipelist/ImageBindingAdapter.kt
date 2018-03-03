package zakharvoit.com.foodhackapp.recipelist

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

object ImageBindingAdapter {
    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageUrl(view: ImageView, url: String) {
        Glide.with(view.context)
                .load(url)
                .apply(RequestOptions.bitmapTransform(
                        RoundedCornersTransformation(50, 0,
                                RoundedCornersTransformation.CornerType.ALL)))
                .into(view)
    }
}