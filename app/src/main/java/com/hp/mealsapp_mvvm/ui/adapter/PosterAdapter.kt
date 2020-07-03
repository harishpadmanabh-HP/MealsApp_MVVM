package com.hp.mealsapp_mvvm.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hp.mealsapp_mvvm.R
import com.hp.mealsapp_mvvm.data.models.Categories
import com.hp.mealsapp_mvvm.databinding.ItemPosterBinding
import java.util.*

class PosterAdapter : RecyclerView.Adapter<PosterAdapter.PosterViewHolder>() {

    private val items = mutableListOf<Categories.Category>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemPosterBinding>(
            inflater, R.layout.item_poster, parent, false
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
        val item = items[position]
        holder.binding.apply {
            poster = item
            veil = itemVeilLayout
            executePendingBindings()
            root.setOnClickListener {
                Toast.makeText(it.context, "Clicked ${item.strCategory}", Toast.LENGTH_SHORT).show()
                // PosterDetailActivity.startActivity(it.context, transformationLayout, item)
            }
        }
    }
    fun getPoster(index: Int): Categories.Category = items[index]



    class PosterViewHolder(val binding: ItemPosterBinding) :
        RecyclerView.ViewHolder(binding.root)
}