package com.ibrahimcherri.restaurants.presentation

import com.ibrahimcherri.restaurants.domain.GetLocationTopRestaurantsUseCase
import com.ibrahimcherri.restaurants.presentation.presenter.RestaurantsPresenter
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.Disposable
import io.reactivex.internal.schedulers.ExecutorScheduler
import io.reactivex.plugins.RxJavaPlugins
import org.junit.Before
import org.junit.Test
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit

class RestaurantsPresenterTest {

    private lateinit var getLocationTopRestaurantsUseCase: GetLocationTopRestaurantsUseCase
    private lateinit var display: RestaurantsPresenter.Display
    private lateinit var presenter: RestaurantsPresenter

    @Before
    fun setup() {
        val immediate = object : Scheduler() {
            override fun scheduleDirect(@NonNull run: Runnable, delay: Long, @NonNull unit: TimeUnit): Disposable {
                // this prevents StackOverflowErrors when scheduling with a delay
                return super.scheduleDirect(run, 0, unit)
            }

            override fun createWorker(): Worker {
                return ExecutorScheduler.ExecutorWorker(Executor { it.run() })
            }
        }

        RxJavaPlugins.setInitIoSchedulerHandler { immediate }
        RxJavaPlugins.setInitComputationSchedulerHandler { immediate }
        RxJavaPlugins.setInitNewThreadSchedulerHandler { immediate }
        RxJavaPlugins.setInitSingleSchedulerHandler { immediate }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { immediate }

        getLocationTopRestaurantsUseCase = mock()
        presenter = RestaurantsPresenter(getLocationTopRestaurantsUseCase)
        display = mock()
        presenter.inject(display)
    }

    @Test
    fun getRestaurantsSuccess() {
        whenever(getLocationTopRestaurantsUseCase.getLocationTopRestaurants("98284", "subzone")).thenReturn(Single.just(listOf()))

        presenter.onResume()

        verify(getLocationTopRestaurantsUseCase).getLocationTopRestaurants("98284", "subzone")

        verify(display).displayRestaurants(any())
    }

    @Test
    fun getRestaurantsFailure() {
        whenever(getLocationTopRestaurantsUseCase.getLocationTopRestaurants("98284", "subzone"))
                .thenReturn(Single.error(java.lang.IllegalArgumentException()))

        presenter.onResume()

        verify(display).displayError()
    }
}