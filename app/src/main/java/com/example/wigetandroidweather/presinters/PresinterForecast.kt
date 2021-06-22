package com.example.wigetandroidweather.presinters

import com.example.wigetandroidweather.MainContract
import com.example.wigetandroidweather.data.repository.Repository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class PresinterForecast @Inject constructor(var forecast: MainContract.View.Forecast,
var repository: Repository):MainContract.Presinter.Forecast {

    override fun loadDataForecast() {

        repository.getForecastWeather().observeOn(AndroidSchedulers.mainThread()).
        subscribeOn(Schedulers.io()).subscribe({ response->forecast.showData(response)
            },
            { response->forecast.netError(response)
            })
    }
}