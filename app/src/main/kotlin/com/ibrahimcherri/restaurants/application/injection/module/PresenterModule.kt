package com.ibrahimcherri.restaurants.application.injection.module

import com.ibrahimcherri.restaurants.domain.GetLocationTopRestaurantsUseCase
import com.ibrahimcherri.restaurants.domain.GetRestaurantsFromDatabaseUseCase
import com.ibrahimcherri.restaurants.domain.UpdateRestaurantsInDatabaseUseCase
import com.ibrahimcherri.restaurants.presentation.presenter.RestaurantsPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {

    @Provides
    @Singleton
    fun provideRestaurantsPresenter(getLocationTopRestaurantsUseCase: GetLocationTopRestaurantsUseCase,
                                    getRestaurantsFromDatabaseUseCase: GetRestaurantsFromDatabaseUseCase,
                                    updateRestaurantsInDatabaseUseCase: UpdateRestaurantsInDatabaseUseCase) =
            RestaurantsPresenter(getLocationTopRestaurantsUseCase,
                    getRestaurantsFromDatabaseUseCase,
                    updateRestaurantsInDatabaseUseCase)
}