package com.ibrahimcherri.restaurants.application.injection.component

import com.ibrahimcherri.restaurants.application.injection.module.*
import com.ibrahimcherri.restaurants.presentation.view.RestaurantsActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class,
    PresenterModule::class,
    UseCaseModule::class,
    ServiceModule::class,
    NetworkModule::class])
interface ApplicationComponent {
    fun inject(restaurantsActivity: RestaurantsActivity)
}