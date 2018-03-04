package zakharvoit.com.foodhackapp.model

import android.graphics.drawable.Drawable
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Ingredient(val id: Int, val title: String, val url: String) : Parcelable {
    override fun equals(other: Any?): Boolean {
        if (other !is Ingredient) return false
        return id == other.id
    }
}
