package com.ibrahimcherri.restaurants.presentation

import com.ibrahimcherri.restaurants.domain.GetLocationTopRestaurantsUseCase
import com.ibrahimcherri.restaurants.domain.GetRestaurantsFromDatabaseUseCase
import com.ibrahimcherri.restaurants.domain.UpdateRestaurantsInDatabaseUseCase
import com.ibrahimcherri.restaurants.presentation.presenter.RestaurantsPresenter
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.subject.SubjectSpek


class RestaurantsPresenterTest : SubjectSpek<RestaurantsPresenter>({

    lateinit var getLocationTopRestaurantsUseCase: GetLocationTopRestaurantsUseCase
    lateinit var getRestaurantsFromDatabaseUseCase: GetRestaurantsFromDatabaseUseCase
    lateinit var updateRestaurantsInDatabaseUseCase: UpdateRestaurantsInDatabaseUseCase
    lateinit var display: RestaurantsPresenter.Display
    lateinit var presenter: RestaurantsPresenter

    subject {
        getLocationTopRestaurantsUseCase = mock()
        getRestaurantsFromDatabaseUseCase = mock()
        updateRestaurantsInDatabaseUseCase = mock()
        display = mock()

        whenever(getLocationTopRestaurantsUseCase.getLocationTopRestaurants("98284", "subzone")).thenReturn(Single.just(listOf()))

        presenter = RestaurantsPresenter(getLocationTopRestaurantsUseCase, getRestaurantsFromDatabaseUseCase, updateRestaurantsInDatabaseUseCase)

        presenter.inject(display)

        presenter
    }

    given("I opened the restaurants view") {
        on("successfully loading the restaurants list") {
            it("displays the the restaurants list") {
                subject.onResume()

                verify(getLocationTopRestaurantsUseCase).getLocationTopRestaurants("98284", "subzone")

                verify(display).displayRestaurants(any())
            }
        }
    }
})