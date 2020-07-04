package com.hp.mealsapp_mvvm.data.repositories

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.hp.mealsapp_mvvm.data.models.Categories
import com.hp.mealsapp_mvvm.data.models.Meals
import com.hp.mealsapp_mvvm.data.network.MyApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class MealsRepo {

    init {
        Timber.d("Repository init")
    }

    fun loadCategories(): LiveData<List<Categories.Category>> {
        var categoryLiveData = MutableLiveData<List<Categories.Category>>()
        MyApi().getCategories().enqueue(object : Callback<Categories> {
            override fun onFailure(call: Call<Categories>, t: Throwable) {

                Log.e("ON Failed ", t.toString())

            }

            override fun onResponse(call: Call<Categories>, response: Response<Categories>) {

                categoryLiveData.postValue(response.body()?.categories)

            }
        })
        Log.e("categoryLiveData livedata value", categoryLiveData.value.toString())
        return categoryLiveData
    }

    fun loadFilteredMeals(c:String):LiveData<List<Meals.Meal>>{
        var mealsData = MutableLiveData<List<Meals.Meal>>()
        MyApi().getFilteredMeals(c).enqueue(object :Callback<Meals>{
            override fun onFailure(call: Call<Meals>, t: Throwable) {
                Log.e("ON Failed ", t.toString())
            }

            override fun onResponse(call: Call<Meals>, response: Response<Meals>) {
               mealsData.postValue(response.body()?.meals)
            }
        })
        return mealsData

    }

}