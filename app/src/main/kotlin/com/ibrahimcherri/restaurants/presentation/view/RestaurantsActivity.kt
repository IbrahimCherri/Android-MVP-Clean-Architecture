package com.ibrahimcherri.restaurants.presentation.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.design.widget.Snackbar
import com.ibrahimcherri.restaurants.R
import com.ibrahimcherri.restaurants.application.RestaurantsApplication
import com.ibrahimcherri.restaurants.domain.model.Restaurant
import com.ibrahimcherri.restaurants.presentation.presenter.RestaurantsPresenter
import kotlinx.android.synthetic.main.activity_restaurants.*
import javax.inject.Inject

class RestaurantsActivity : AppCompatActivity(), RestaurantsPresenter.Display {

    @Inject
    lateinit var presenter: RestaurantsPresenter

    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurants)

        (application as RestaurantsApplication).applicationComponent.inject(this)

        presenter.inject(this)
    }

    override fun onResume() {
        super.onResume()

        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()

        presenter.onPause()
    }

    override fun displayRestaurants(restaurants: List<Restaurant>) {
        viewManager = LinearLayoutManager(this)
        viewAdapter = RestaurantsAdapter(restaurants)

        restaurantsList.setHasFixedSize(true)
        restaurantsList.layoutManager = viewManager
        restaurantsList.adapter = viewAdapter
    }

    override fun displayError() {
        Snackbar.make(rootView, R.string.restarants_load_error, Snackbar.LENGTH_LONG)
                .show()
    }
}
