package com.github.adnanrangrej.todonow

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TodoNowApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}