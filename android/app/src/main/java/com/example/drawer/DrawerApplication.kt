package com.example.drawer

import android.app.Application
import com.example.drawer.beagle.BeagleSetup

class DrawerApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        BeagleSetup().init(this)
    }
}
