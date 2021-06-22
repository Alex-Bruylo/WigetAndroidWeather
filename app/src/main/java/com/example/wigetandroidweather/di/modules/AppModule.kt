package com.example.wigetandroidweather.di.modules

import android.app.Activity
import androidx.fragment.app.Fragment
import com.example.wigetandroidweather.MainContract
import com.example.wigetandroidweather.presinters.PresenterToday
import com.example.wigetandroidweather.presinters.PresinterForecast
import com.example.wigetandroidweather.ui.weather_activity.WeatherActivity
import com.example.wigetandroidweather.ui.weather_activity.forecast.ForecastFragment
import com.example.wigetandroidweather.ui.weather_activity.today.TodayFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent

//AppModule module provide interface presenters and views by Hilt in this app
// Fragment module provide views by Hilt in this app

@InstallIn(FragmentComponent::class)
@Module
abstract class MVPModule {

    @Binds
   abstract fun bindViewForecast (fragmentForecast: ForecastFragment): MainContract.View.Forecast

    @Binds
    abstract fun bindViewToday (fragmentToday: TodayFragment): MainContract.View.Today

    @Binds
    abstract fun bindPresenterToday (presenter: PresenterToday): MainContract.Presinter.Today

    @Binds
    abstract fun bindPresenterForecast (presenter: PresinterForecast): MainContract.Presinter.Forecast
}

    @InstallIn(FragmentComponent::class)
    @Module
    object FragmentModule{

    @Provides
    fun bindViewForecast(fragment: Fragment): ForecastFragment {
        return fragment as ForecastFragment
    }

    @Provides
    fun bindViewToday (fragment: Fragment): TodayFragment {
        return fragment as TodayFragment
    }

}

