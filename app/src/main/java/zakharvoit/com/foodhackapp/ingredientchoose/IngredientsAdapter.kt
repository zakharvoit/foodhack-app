package zakharvoit.com.foodhackapp.ingredientchoose

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import zakharvoit.com.foodhackapp.R
import zakharvoit.com.foodhackapp.model.Ingredient

class IngredientsAdapter(context: Context) : ArrayAdapter<Ingredient>(context, 0) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = when (convertView) {
            null -> {
                val inflater = LayoutInflater.from(context)
                inflater.inflate(R.layout.ingredient_item, parent, false)
            }
            else -> {
                convertView
            }
        }
        val image = view.findViewById<ImageView>(R.id.ingredient_image)
        val text = view.findViewById<TextView>(R.id.ingredient_title)

        Glide.with(context).load(getItem(position).url).into(image)
        text.text = getItem(position).title
        return view
    }
}