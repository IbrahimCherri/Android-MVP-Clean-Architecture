package com.ibrahimcherri.restaurants.application.injection.module

import com.ibrahimcherri.restaurants.domain.GetLocationTopRestaurantsUseCase
import com.ibrahimcherri.restaurants.domain.ZamatoRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideHttpCache(zamatoRepository: ZamatoRepository): GetLocationTopRestaurantsUseCase =
            GetLocationTopRestaurantsUseCase(zamatoRepository)
}