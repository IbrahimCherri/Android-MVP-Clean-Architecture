package com.ibrahimcherri.restaurants.presentation.presenter

import com.ibrahimcherri.restaurants.domain.GetLocationTopRestaurantsUseCase
import com.ibrahimcherri.restaurants.domain.model.Restaurant
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

open class RestaurantsPresenter @Inject constructor(private val getLocationTopRestaurantsUseCase: GetLocationTopRestaurantsUseCase) {

    private companion object {
        const val LOCATION_ID = "98284"
        const val LOCATION_TYPE = "subzone"
    }

    private lateinit var display: Display
    private lateinit var apiSubscription: Disposable

    fun inject(display: Display) {
        this.display = display
    }

    fun onResume() {
        apiSubscription = getLocationTopRestaurantsUseCase.getLocationTopRestaurants(LOCATION_ID, LOCATION_TYPE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            display.displayRestaurants(it)
                        },
                        {
                            display.displayError()
                        })
    }

    fun onPause() {
        apiSubscription.dispose()
    }

    interface Display {
        fun displayRestaurants(restaurants: List<Restaurant>)
        fun displayError()
    }
}