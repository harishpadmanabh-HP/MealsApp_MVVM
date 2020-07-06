/*
 * Designed and developed by 2020 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hp.mealsapp_mvvm.binding

import android.graphics.Color
import android.view.View
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.hp.mealsapp_mvvm.data.models.Categories
import com.hp.mealsapp_mvvm.data.models.Meals
import com.hp.mealsapp_mvvm.extensions.circularRevealedAtCenter
import com.hp.mealsapp_mvvm.ui.adapter.MealsAdapter
import com.hp.mealsapp_mvvm.ui.adapter.PosterAdapter

import com.skydoves.whatif.whatIfNotNull
import com.skydoves.whatif.whatIfNotNullOrEmpty
import com.yarolegovich.discretescrollview.DiscreteScrollView
import com.yarolegovich.discretescrollview.transform.ScaleTransformer

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, baseAdapter: RecyclerView.Adapter<*>) {
    view.adapter = baseAdapter
}

@BindingAdapter("toast")
fun bindToast(view: RecyclerView, text: LiveData<String>) {
    text.value.whatIfNotNull {
        Toast.makeText(view.context, it, Toast.LENGTH_SHORT).show()
    }
}

@BindingAdapter("adapterPosterList")
fun bindAdapterPosterList(view: DiscreteScrollView, posters: List<Categories.Category>?) {
    posters.whatIfNotNullOrEmpty {
        (view.adapter as? PosterAdapter)?.updatePosterList(it)
    }
    view.setItemTransformer(
        ScaleTransformer.Builder()
            .setMaxScale(1.25f)
            .setMinScale(0.8f)
            .build()
    )
}

@BindingAdapter("bindOnItemChanged", "bindOnItemChangedBackground")
fun bindOnItemChanged(view: DiscreteScrollView, adapter: PosterAdapter, pointView: View) {
    view.addOnItemChangedListener { viewHolder, _ ->
        viewHolder?.adapterPosition.whatIfNotNull {
            var colors = arrayOf(Color.RED, Color.BLACK, Color.YELLOW, Color.DKGRAY)
            var randomColorindex = (0..3).random()

            pointView.circularRevealedAtCenter(colors[randomColorindex])
        }
    }
}

@BindingAdapter("adapterMealList")
fun bindMealsList(
    view: RecyclerView,
    meals: List<Meals.Meal>?
) {
    meals.whatIfNotNullOrEmpty {
        (view.adapter as? MealsAdapter)?.updateMealsList(it)
    }
}

//
//@BindingAdapter("adapterPosterSeries", "adapterPosterDetailsList")
//fun bindAdapterPosterDetailsList(
//  view: RecyclerView,
//  adapter: PosterSeriesAdapter,
//  posters: List<PosterDetails>?
//) {
//  posters.whatIfNotNullOrEmpty {
//    view.adapter = adapter.apply { updatePosterDetailsList(it) }
//  }
//}
