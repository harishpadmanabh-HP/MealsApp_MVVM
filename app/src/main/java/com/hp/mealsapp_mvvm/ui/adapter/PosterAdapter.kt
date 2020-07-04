package com.hp.mealsapp_mvvm.ui.adapter

import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hp.mealsapp_mvvm.R
import com.hp.mealsapp_mvvm.data.models.Categories
import com.hp.mealsapp_mvvm.databinding.ItemCategoryBinding
import com.hp.mealsapp_mvvm.ui.MealsActivity
import timber.log.Timber

class PosterAdapter : RecyclerView.Adapter<PosterAdapter.PosterViewHolder>() {

    private val items = mutableListOf<Categories.Category>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemCategoryBinding>(
            inflater, R.layout.item_category, parent, false
        )
        return PosterViewHolder(binding)
    }

    fun updatePosterList(posters: List<Categories.Category>) {
        items.clear()
        items.addAll(posters)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {

        return items.size

    }

    override fun onBindViewHolder(holder: PosterViewHolder, position: Int) {
        Timber.e("Binded")
        val item = items[position]
        holder.binding.apply {
            poster = item
            itemPosterDesc.movementMethod=(ScrollingMovementMethod())
            veil = itemVeilLayout
            executePendingBindings()
            root.setOnClickListener {
                Toast.makeText(it.context, "You chose ${item.strCategory}", Toast.LENGTH_SHORT).show()
                 MealsActivity.startActivity(it.context, transformationLayout, item)
            }
        }
    }
    fun getPoster(index: Int): Categories.Category = items[index]



    class PosterViewHolder(val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)
}