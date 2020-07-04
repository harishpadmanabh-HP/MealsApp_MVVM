package com.hp.mealsapp_mvvm.ui.categorySelection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hp.mealsapp_mvvm.data.models.Categories
import com.hp.mealsapp_mvvm.data.repositories.MealsRepo

class MainActivityViewModel() : ViewModel() {

    val toastLiveData: MutableLiveData<String> = MutableLiveData()
    val posterLiveData: LiveData<List<Categories.Category>>
                       = MealsRepo().loadCategories()

    fun fetchCategory() = posterLiveData


}