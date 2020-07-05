package com.hp.mealsapp_mvvm.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Log.e
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.hp.mealsapp_mvvm.R
import com.hp.mealsapp_mvvm.base.DatabindingActivity
import com.hp.mealsapp_mvvm.data.models.Categories
import com.hp.mealsapp_mvvm.databinding.ActivityMealsActivtyBinding
import com.hp.mealsapp_mvvm.extensions.onTransformationEndContainerApplyParams
import com.hp.mealsapp_mvvm.ui.adapter.MealsAdapter
import com.skydoves.transformationlayout.TransformationCompat
import com.skydoves.transformationlayout.TransformationLayout

class MealsActivity : DatabindingActivity() {

    private lateinit var viewModel: MealsActivityViewModel
    private val binding : ActivityMealsActivtyBinding by binding(R.layout.activity_meals_activty)
    @SuppressLint("LogNotTimber")
    override fun onCreate(savedInstanceState: Bundle?) {
        onTransformationEndContainerApplyParams()
        super.onCreate(savedInstanceState)

        viewModel=ViewModelProviders.of(this).get(MealsActivityViewModel::class.java)

        binding.viewmodel=viewModel.apply {
fetchmeals(intent.getStringExtra(categorySelected))
        }
        binding.mealsList.layoutManager =  StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.adapter=MealsAdapter()
        binding.lifecycleOwner=this

        viewModel.heading.observe(this, Observer {
            binding.mealsHeading.text = it
        })


        val selectedCategory = intent.getStringExtra(categorySelected)
       viewModel.mealsLiveData.observe(this, Observer {

           for(meal in it){
               Log.e("$selectedCategory",meal.strMeal)
           }
       })




    }

    companion object {
        private const val categorySelected = "categorySelected"
        fun startActivity(
            context: Context,
            transformationLayout: TransformationLayout,
            poster: Categories.Category
        ) {
            val intent = Intent(context, MealsActivity::class.java)
            intent.putExtra(categorySelected, poster.strCategory)
            TransformationCompat.startActivity(transformationLayout, intent)
        }
    }
}