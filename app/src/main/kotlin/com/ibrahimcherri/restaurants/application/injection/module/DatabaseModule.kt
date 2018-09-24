package com.ibrahimcherri.restaurants.application.injection.module

import android.app.Application
import android.arch.persistence.room.Room
import com.ibrahimcherri.restaurants.room.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideRoom(application: Application) =
            Room.databaseBuilder(application, AppDatabase::class.java, "restaurants-db")
                    .build()
}