package com.hp.mealsapp_mvvm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hp.mealsapp_mvvm.data.models.Categories
import com.hp.mealsapp_mvvm.data.models.Meals
import com.hp.mealsapp_mvvm.data.repositories.MealsRepo

class MealsActivityViewModel : ViewModel() {
    var mealsLiveData : LiveData<List<Meals.Meal>>
            = MealsRepo().loadFilteredMeals("beef")

    var heading =MutableLiveData<String>()

    fun fetchMealsData() = mealsLiveData

    fun fetchmeals(c:String){
        heading.postValue(c)
        mealsLiveData=MealsRepo().loadFilteredMeals(c)
        fetchMealsData()
    }





}