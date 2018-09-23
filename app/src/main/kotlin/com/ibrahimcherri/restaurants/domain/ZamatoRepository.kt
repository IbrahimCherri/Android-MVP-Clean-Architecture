package com.ibrahimcherri.restaurants.domain

import com.ibrahimcherri.restaurants.domain.model.Restaurant
import io.reactivex.Single

interface ZamatoRepository {

    fun getLocationDetails(locationId: String, locationType: String): Single<List<Restaurant>>
}