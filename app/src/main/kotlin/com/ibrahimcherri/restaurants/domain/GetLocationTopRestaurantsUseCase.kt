package com.ibrahimcherri.restaurants.domain

import com.ibrahimcherri.restaurants.domain.model.Restaurant
import io.reactivex.Single
import javax.inject.Inject

open class GetLocationTopRestaurantsUseCase @Inject constructor(private val zamatoRepository: ZamatoRepository) {

    open fun getLocationTopRestaurants(locationId: String, locationType: String): Single<List<Restaurant>> {
        return zamatoRepository.getLocationDetails(locationId, locationType)
    }
}