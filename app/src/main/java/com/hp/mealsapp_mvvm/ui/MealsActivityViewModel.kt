package com.hp.mealsapp_mvvm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hp.mealsapp_mvvm.data.models.Categories
import com.hp.mealsapp_mvvm.data.models.Meals
import com.hp.mealsapp_mvvm.data.repositories.MealsRepo

class MealsActivityViewModel : ViewModel() {

    // var mealsLiveData = MutableLiveData<List<Meals.Meal>>()

    val posterLiveData: LiveData<List<Meals.Meal>>
            = MealsRepo().loadFilteredMeals("beef")

    fun fetchCategory() = posterLiveData


//    fun getFilteredMeals(c:String):LiveData<List<Meals.Meal>>{
//
//     var   mealsLiveData=       MealsRepo().loadFilteredMeals(c)
//
//        return mealsLiveData
//    }

}