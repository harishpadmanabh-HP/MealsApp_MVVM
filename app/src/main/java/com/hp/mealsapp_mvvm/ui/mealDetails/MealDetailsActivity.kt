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
import com.hp.mealsapp_mvvm.extensions.makeStatusBarTransparent
import com.hp.mealsapp_mvvm.ui.MealsActivity
import com.hp.mealsapp_mvvm.ui.YoutubePlayerActivity
import com.skydoves.marvelheroes.binding.bindLoadImage
import kotlinx.android.synthetic.main.activity_meal_details.*
import timber.log.Timber

class MealDetailsActivity : DatabindingActivity() {

    private val binding: ActivityMealDetailsBinding by binding(R.layout.activity_meal_details)
    private lateinit var viewmodel: MealDetailsViewmodel
    var playURL: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        makeStatusBarTransparent()
        viewmodel = ViewModelProvider(this).get(MealDetailsViewmodel::class.java)
        binding.lifecycleOwner = this
        viewmodel.fetchData(idmeal)
        viewmodel.posterLiveData.observe(this, Observer {
            for (meal in it.meals) {

                Log.e("DETAILMEALS", meal.strMealThumb.trim())
            }
            binding.mealDeatails = it
            about_textView.text = "Watch about ${it.meals.get(0).strMeal}"
            var url: String = it.meals.get(0).strMealThumb
            playURL=it.meals.get(0).strYoutube
            Timber.e("LOAD URL $url")
            Glide.with(this@MealDetailsActivity)
                .load(url.trim())
                .placeholder(R.drawable.marvel)
                .into(binding.mealImageView)
        })

        binding.playVideoLayout.setOnClickListener{
            Timber.d("PLAY URL : $playURL")
            startActivity(Intent(this,YoutubePlayerActivity::class.java).putExtra("playurl",playURL))
        }

    }

    companion object {
        var idmeal = ""
        fun startActivity(
            context: Context,
            idMealSelected: String
        ) {
            idmeal = idMealSelected
            val intent = Intent(context, MealDetailsActivity::class.java)

            context.startActivity(intent)
        }

    }
}