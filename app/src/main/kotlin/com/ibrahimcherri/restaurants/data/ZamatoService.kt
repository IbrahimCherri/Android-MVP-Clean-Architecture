package com.ibrahimcherri.restaurants.data

import com.ibrahimcherri.restaurants.BuildConfig
import com.ibrahimcherri.restaurants.data.model.LocationDetailsResponse
import com.ibrahimcherri.restaurants.domain.ZamatoRepository
import com.ibrahimcherri.restaurants.domain.model.Restaurant
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import java.net.URI
import javax.inject.Inject

class ZamatoService @Inject constructor(retrofit: Retrofit) : ZamatoRepository {
    private val locationApi = retrofit.create(LocationApi::class.java)

    override fun getLocationDetails(locationId: String, locationType: String): Single<List<Restaurant>> =
            locationApi.getLocationDetailsApi(locationId, locationType)
                    .map(::mapLocationDetailsToDomainRestaurants)

    interface LocationApi {
        @GET("location_details")
        fun getLocationDetailsApi(@Query("entity_id") locationId: String,
                                  @Query("entity_type") locationType: String,
                                  @Header("user-key") userKey: String = BuildConfig.API_KEY): Single<LocationDetailsResponse>
    }
}

