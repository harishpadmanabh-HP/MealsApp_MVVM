package com.hp.mealsapp_mvvm.ui.mealDetails

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.hp.mealsapp_mvvm.R
import com.hp.mealsapp_mvvm.base.DatabindingActivity
import com.hp.mealsapp_mvvm.data.models.MealDetails
import com.hp.mealsapp_mvvm.databinding.ActivityMealDetailsBinding
import com.hp.mealsapp_mvvm.ui.MealsActivity
import com.skydoves.marvelheroes.binding.bindLoadImage
import kotlinx.android.synthetic.main.activity_meal_details.*

class MealDetailsActivity : DatabindingActivity() {

    private val binding:ActivityMealDetailsBinding by binding(R.layout.activity_meal_details)
    private lateinit var  viewmodel:MealDetailsViewmodel
    var mealid : String = " "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewmodel=ViewModelProvider(this).get(MealDetailsViewmodel::class.java)
        binding.lifecycleOwner=this
        //binding.veil=veilLayout
        viewmodel.posterLiveData.observe(this, Observer {
            for(meal in it.meals)
            {
               // bindLoadImage(binding.mealImageView,meal.strMealThumb)


                Log.e("DETAILMEALS",meal.strMealThumb.trim())
            }
            binding.mealDeatails=it
            var url : String = it.meals.get(0).strMealThumb
            Log.e("DETAILMEALS out",url)
            Glide.with(this@MealDetailsActivity)
                .load(url.trim())
                .placeholder(R.drawable.marvel)
                .into(binding.mealImageView)



        })








    }

    companion object{
        var idmeal = ""
        fun startActivity(
            context:Context,
            idMealSelected:String
        ){
            idmeal=idMealSelected
            val intent = Intent(context, MealDetailsActivity::class.java)

            context.startActivity(intent)
        }

    }
}