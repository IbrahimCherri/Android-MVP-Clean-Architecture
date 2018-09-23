package com.ibrahimcherri.restaurants.application.injection.module

import com.ibrahimcherri.restaurants.data.ZamatoService
import com.ibrahimcherri.restaurants.domain.ZamatoRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideZamatoService(retrofit: Retrofit): ZamatoRepository = ZamatoService(retrofit)
}