package com.example.wigetandroidweather.data.net
import com.example.wigetandroidweather.API_KEY
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface API {

@GET("find?units=metric")
 fun getWeather(@Query("lat") lat:Double , @Query("lon") lon:Double,
@Query("appid") key: String):Observable<Response>

@GET("forecast?")
fun getForecastWeather(@Query("lat") lat:Double, @Query("lon") lon:Double,
                       @Query("appid") key: String):Observable<ForecastResponse>
}
