package com.hp.mealsapp_mvvm.ui.mealDetails

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hp.mealsapp_mvvm.data.models.Categories
import com.hp.mealsapp_mvvm.data.models.MealDetails
import com.hp.mealsapp_mvvm.data.models.Meals
import com.hp.mealsapp_mvvm.data.network.MyApi
import com.hp.mealsapp_mvvm.data.repositories.MealsRepo

class MealDetailsViewmodel: ViewModel() {

    var posterLiveData=  MutableLiveData<MealDetails>()
            //= MealsRepo().loadMealDetails("52772")
    fun fetchData()=posterLiveData

    fun fetchData(id:String):MutableLiveData<MealDetails>{
        posterLiveData = MealsRepo().loadMealDetails(id)
        fetchData()
        return posterLiveData
    }






}