package com.ibrahimcherri.restaurants.presentation.presenter

import com.ibrahimcherri.restaurants.domain.GetLocationTopRestaurantsUseCase
import javax.inject.Inject

open class RestaurantsPresenter @Inject constructor(private val getLocationTopRestaurantsUseCase: GetLocationTopRestaurantsUseCase) {

    fun onActivityReady() {

        val result = getLocationTopRestaurantsUseCase.getLocationTopRestaurants("98284", "subzone")
                .subscribe(
                        {

                        },
                        {

                        })
    }
}