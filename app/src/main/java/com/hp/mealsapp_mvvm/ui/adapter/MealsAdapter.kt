package com.hp.mealsapp_mvvm.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hp.mealsapp_mvvm.R
import com.hp.mealsapp_mvvm.data.models.Meals
import com.hp.mealsapp_mvvm.databinding.ItemMealsBinding
import com.hp.mealsapp_mvvm.ui.mealDetails.MealDetailsActivity
import timber.log.Timber

class MealsAdapter : RecyclerView.Adapter<MealsAdapter.MealsViewHolder>() {

    val mealitems = mutableListOf<Meals.Meal>()

    class MealsViewHolder(val binding: ItemMealsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealsViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemMealsBinding>(
            inflater, R.layout.item_meals, parent, false
        )
        return MealsViewHolder(binding)

    }
    fun updateMealsList(meals: List<Meals.Meal>) {
        mealitems.clear()
        mealitems.addAll(meals)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
      return mealitems.size
    }

    override fun onBindViewHolder(holder: MealsViewHolder, position: Int) {
        Timber.e("Binded")

        val item = mealitems[position]
        holder.binding.apply {
            meal = item
            veil = itemVeilLayout
            executePendingBindings()
            root.setOnClickListener {
                Toast.makeText(it.context, "You chose ${item.strMeal}", Toast.LENGTH_SHORT).show()
               // MealsActivity.startActivity(it.context, transformationLayout, item)

                MealDetailsActivity.startActivity(it.context,mealitems[position].idMeal)
            }
        }    }
}