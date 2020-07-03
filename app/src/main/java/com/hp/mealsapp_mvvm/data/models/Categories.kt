package com.hp.mealsapp_mvvm.data.models


import com.google.gson.annotations.SerializedName

data class Categories(
    val categories: List<Category>
) {
    data class Category(
        val idCategory: String,
        val strCategory: String,
        val strCategoryDescription: String,
        val strCategoryThumb: String
    )
}