package zakharvoit.com.foodhackapp.ingredientchoose

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

import com.mindorks.placeholderview.Animation
import com.mindorks.placeholderview.PlaceHolderView
import com.mindorks.placeholderview.annotations.Animate
import com.mindorks.placeholderview.annotations.Layout
import com.mindorks.placeholderview.annotations.LongClick
import com.mindorks.placeholderview.annotations.NonReusable
import com.mindorks.placeholderview.annotations.Resolve
import com.mindorks.placeholderview.annotations.View

import zakharvoit.com.foodhackapp.R
import zakharvoit.com.foodhackapp.model.Ingredient

@Animate(Animation.ENTER_LEFT_DESC)
@NonReusable
@Layout(R.layout.ingredient_item)
class IngredientItemView(private val mContext: Context, private val mPlaceHolderView: PlaceHolderView, private val mIngredient: Ingredient) {

    @View(R.id.ingredient_image)
    private val imageView: ImageView? = null

    @Resolve
    private fun onResolved() {
        Glide.with(mContext).load("http://lenagold.ru/fon/clipart/m/mjas/mjaso18.jpg").into(imageView!!)
    }

    @LongClick(R.id.ingredient_image)
    private fun onLongClick() {
        mPlaceHolderView.removeView(this)
    }

}
