package com.ibrahimcherri.restaurants.application

import android.app.Application
import com.ibrahimcherri.restaurants.application.injection.component.ApplicationComponent
import com.ibrahimcherri.restaurants.application.injection.component.DaggerApplicationComponent
import com.ibrahimcherri.restaurants.application.injection.module.ApplicationModule

class RestaurantsApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}