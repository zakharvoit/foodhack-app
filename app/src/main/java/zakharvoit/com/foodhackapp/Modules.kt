package zakharvoit.com.foodhackapp

import zakharvoit.com.foodhackapp.api.apiModule
import zakharvoit.com.foodhackapp.ingredientchoose.ingredientChooseModule
import zakharvoit.com.foodhackapp.main.mainModule
import zakharvoit.com.foodhackapp.recipelist.recipeListModule

val foodhackModules = listOf(
        mainModule,
        apiModule,
        ingredientChooseModule,
        recipeListModule
)

