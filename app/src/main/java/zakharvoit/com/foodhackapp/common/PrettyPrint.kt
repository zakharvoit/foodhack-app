package zakharvoit.com.foodhackapp.common

import zakharvoit.com.foodhackapp.api.dishes.EnergyValue

fun Int.asMissing(): String = "Не хватает ингредиентов: " + this

fun Int.asMinutes(): String = this.toString() + " мин"

fun Double.asCalories(): String = this.toString() + " Ккал"

fun Double.asFats(): String = "Жиры: " + this.toString()

fun Double.asProtein(): String = "Белки: " + this.toString()

fun Double.asCarbs(): String = "Углеводы: " + this.toString()

fun EnergyValue.prettyPrint(): String = "Белки: " + protein + "Ккал: " + calories