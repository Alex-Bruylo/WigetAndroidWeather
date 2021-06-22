package com.example.wigetandroidweather.data.repository

import com.example.wigetandroidweather.API_KEY
import com.example.wigetandroidweather.data.net.API
import com.example.wigetandroidweather.data.net.ForecastResponse
import com.example.wigetandroidweather.data.net.Response

import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class Repository @Inject constructor(var retrofit: API){

    fun getWeather(): Observable<Response> {
       return retrofit.getWeather(	53.66, 	23.8, API_KEY)
    }

    fun getForecastWeather(): Observable<ForecastResponse> {
        return retrofit.getForecastWeather(53.66, 	23.8, API_KEY)
    }
}