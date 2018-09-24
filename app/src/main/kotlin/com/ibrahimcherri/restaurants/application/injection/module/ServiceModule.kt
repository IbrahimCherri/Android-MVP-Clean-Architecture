package com.ibrahimcherri.restaurants.application.injection.module

import com.ibrahimcherri.restaurants.data.ZamatoService
import com.ibrahimcherri.restaurants.domain.RestaurantRepository
import com.ibrahimcherri.restaurants.domain.ZamatoRepository
import com.ibrahimcherri.restaurants.room.AppDatabase
import com.ibrahimcherri.restaurants.room.RestaurantService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideZamatoService(retrofit: Retrofit): ZamatoRepository = ZamatoService(retrofit)

    @Provides
    @Singleton
    fun provideRestaurantService(appDatabase: AppDatabase): RestaurantRepository = RestaurantService(appDatabase)
}