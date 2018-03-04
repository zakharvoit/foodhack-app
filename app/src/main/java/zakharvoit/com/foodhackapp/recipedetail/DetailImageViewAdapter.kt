package zakharvoit.com.foodhackapp.recipedetail

import android.databinding.BindingAdapter
import android.widget.ImageView
import zakharvoit.com.foodhackapp.common.setGoodFullScreenImage

object DetailImageViewAdapter {
    @JvmStatic
    @BindingAdapter("app:detailImageView")
    fun setImageUrl(view: ImageView, url: String) {
        setGoodFullScreenImage(view, view.context, url)
    }
}