package com.ibrahimcherri.restaurants.application.injection.module

import com.ibrahimcherri.restaurants.domain.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideLocationTopRestaurants(zamatoRepository: ZamatoRepository): GetLocationTopRestaurantsUseCase =
            GetLocationTopRestaurantsUseCase(zamatoRepository)

    @Provides
    @Singleton
    fun provideGetRestaurantsFromDatabase(restaurantRepository: RestaurantRepository): GetRestaurantsFromDatabaseUseCase =
            GetRestaurantsFromDatabaseUseCase(restaurantRepository)

    @Provides
    @Singleton
    fun provideUpdateRestaurantsInDatabase(restaurantRepository: RestaurantRepository): UpdateRestaurantsInDatabaseUseCase =
            UpdateRestaurantsInDatabaseUseCase(restaurantRepository)
}