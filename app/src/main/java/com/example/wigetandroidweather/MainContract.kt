package com.example.wigetandroidweather


import com.example.wigetandroidweather.data.net.ForecastResponse
import com.example.wigetandroidweather.data.net.Response
import java.lang.Error

interface MainContract{

    interface Presinter{

    interface Forecast{
        fun loadDataForecast()
    }

    interface Today{
        fun loadDataToday()
    }}


    interface View{

   interface Forecast{
       fun getData()
       fun netError(e:Throwable)
       fun showData(responseForecast: ForecastResponse)
       fun setTitleActivity(titile:String)
   }


        interface Today{
            fun getData()
            fun netError(rez:Throwable)
            fun showLoader()
            fun hideLoader()
            fun showData(response: Response)

        }


    }


}