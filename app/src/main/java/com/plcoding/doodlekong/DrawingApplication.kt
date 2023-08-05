package com.plcoding.doodlekong

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp //tag to tell Hilt that this is the class to get the context from
class DrawingApplication : Application () {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree()) //setup logging
    }
}