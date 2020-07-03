package com.hp.mealsapp_mvvm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hp.mealsapp_mvvm.data.models.Categories
import com.hp.mealsapp_mvvm.data.repositories.MealsRepo
import retrofit2.Response

class MainActivityViewModel() : ViewModel() {

    val toastLiveData: MutableLiveData<String> = MutableLiveData()
    val posterLiveData: LiveData<List<Categories.Category>>
                       = MealsRepo().loadCategories()

    fun fetchCategory() = posterLiveData


}