package com.ibrahimcherri.restaurants.presentation.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ibrahimcherri.restaurants.R
import com.ibrahimcherri.restaurants.application.RestaurantsApplication
import com.ibrahimcherri.restaurants.presentation.presenter.RestaurantsPresenter
import retrofit2.Retrofit
import javax.inject.Inject

class RestaurantsActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: RestaurantsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurants)

        (application as RestaurantsApplication).applicationComponent.inject(this)
    }

    override fun onStart() {
        super.onStart()

        presenter.onActivityReady()
    }
}
