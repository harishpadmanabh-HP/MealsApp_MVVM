package com.hp.mealsapp_mvvm.ui.categorySelection

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.hp.mealsapp_mvvm.R
import com.hp.mealsapp_mvvm.base.DatabindingActivity
import com.hp.mealsapp_mvvm.databinding.ActivityMainBinding
import com.hp.mealsapp_mvvm.ui.adapter.PosterAdapter
import com.skydoves.transformationlayout.onTransformationStartContainer

class MainActivity : DatabindingActivity() {

    private val binding: ActivityMainBinding by binding(R.layout.activity_main)
    private lateinit var viewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        onTransformationStartContainer()
        super.onCreate(savedInstanceState)

        viewModel=ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        binding.apply {
            lifecycleOwner = this@MainActivity
            vm=viewModel.apply {
                fetchCategory()
            }
            adapter = PosterAdapter()


        }
    }


}