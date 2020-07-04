package com.hp.mealsapp_mvvm.data.models


import com.google.gson.annotations.SerializedName

data class Meals(
    val meals: List<Meal>
) {
    data class Meal(
        val idMeal: String,
        val strMeal: String,
        val strMealThumb: String
    )
}