package com.hp.mealsapp_mvvm

import android.app.Application
import timber.log.Timber
import timber.log.Timber.DebugTree


class MealsBaseApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
}